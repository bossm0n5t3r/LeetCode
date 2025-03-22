import fuel.Fuel
import fuel.post
import kotlinx.io.readString
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

object LeetCodeClient {
    private const val DOMAIN = "https://leetcode.com"
    private const val GRAPHQL_URL = "$DOMAIN/graphql"
    private const val LANG_KOTLIN = "Kotlin"

    private const val QUERY = """
        query GetDailyLeetCodeProblem {
            activeDailyCodingChallengeQuestion {
                link
                question {
                    questionFrontendId
                    title
                    content
                    difficulty
                    exampleTestcases
                    codeSnippets {
                        lang
                        langSlug
                        code
                    }
                    sampleTestCase
                    metaData
                }
            }
        }
    """
    private val TRIM_INDENTED_QUERY = QUERY.trimIndent()

    @Serializable
    data class DailyLeetCodeProblem(
        val data: Data,
    ) {
        @Serializable
        data class Data(
            val activeDailyCodingChallengeQuestion: ActiveDailyCodingChallengeQuestion,
        ) {
            @Serializable
            data class ActiveDailyCodingChallengeQuestion(
                val link: String,
                val question: Question,
            ) {
                @Serializable
                data class Question(
                    val questionFrontendId: String,
                    val title: String,
                    val content: String,
                    val difficulty: String,
                    val exampleTestcases: String,
                    val codeSnippets: List<CodeSnippet>,
                    val sampleTestCase: String,
                    val metaData: String,
                ) {
                    @Serializable
                    data class CodeSnippet(
                        val lang: String,
                        val langSlug: String,
                        val code: String,
                    )
                }
            }
        }

        val name: String by lazy {
            "${data.activeDailyCodingChallengeQuestion.question.questionFrontendId}. ${data.activeDailyCodingChallengeQuestion.question.title}"
        }

        val url: String by lazy {
            "$DOMAIN${data.activeDailyCodingChallengeQuestion.link}"
        }

        val sampleCodes: List<String> by lazy {
            data.activeDailyCodingChallengeQuestion.question.codeSnippets
                .find { it.lang == LANG_KOTLIN }
                ?.code
                ?.split("\n")
                ?: throw Exception("No Kotlin code snippet found")
        }

        val methodParametersAndResultAsString: String by lazy {
            sampleCodes[1]
                .substringAfter('(')
                .substringBefore('{')
                .split(", ", "): ")
                .let {
                    val lastIndex = it.lastIndex
                    it.mapIndexed { index, s ->
                        if (index != lastIndex) {
                            "val ${s.trim()}"
                        } else {
                            "val result: ${s.trim()}"
                        }
                    }
                }.joinToString(", ")
        }

        val exampleTestcases: String by lazy {
            data.activeDailyCodingChallengeQuestion.question.exampleTestcases
                .replace("\n", " / ")
        }
    }

    suspend fun getDailyLeetCodeProblem(): DailyLeetCodeProblem {
        val response =
            Fuel
                .post(
                    url = GRAPHQL_URL,
                    headers = mapOf("Content-Type" to "application/json"),
                    body = Json.encodeToString(mapOf("query" to TRIM_INDENTED_QUERY)),
                ).source
                .readString()
        return Json.decodeFromString(DailyLeetCodeProblem.serializer(), response)
    }
}
