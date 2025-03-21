import fuel.Fuel
import fuel.post
import kotlinx.io.readString
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

object LeetCodeClient {
    private const val URL = "https://leetcode.com/graphql"
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
    }

    suspend fun getDailyLeetCodeProblem(): DailyLeetCodeProblem {
        val response =
            Fuel
                .post(
                    url = URL,
                    headers = mapOf("Content-Type" to "application/json"),
                    body = Json.encodeToString(mapOf("query" to TRIM_INDENTED_QUERY)),
                ).source
                .readString()
        return Json.decodeFromString(DailyLeetCodeProblem.serializer(), response)
    }
}
