package deleteOperationForTwoStrings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DeleteOperationForTwoStringsTest {
    private val deleteOperationForTwoStrings = DeleteOperationForTwoStrings()

    private data class DeleteOperationForTwoStringsTestData(
        val word1: String,
        val word2: String,
        val result: Int
    )

    @Test
    fun minDistance() {
        val tests = listOf(
            DeleteOperationForTwoStringsTestData(
                "sea", "eat", 2
            ),
            DeleteOperationForTwoStringsTestData(
                "leetcode", "etco", 4
            ),
            DeleteOperationForTwoStringsTestData(
                "a", "a", 0
            ),
            DeleteOperationForTwoStringsTestData(
                "sea", "ate", 4
            ),
            DeleteOperationForTwoStringsTestData(
                "intention", "execution", 8
            ),
            DeleteOperationForTwoStringsTestData(
                "abcdxabcde", "abcdeabcdx", 4
            ),
            DeleteOperationForTwoStringsTestData(
                "food", "money", 7
            ),
        )
        tests.forEach { test ->
            deleteOperationForTwoStrings.minDistance(test.word1, test.word2)
                .also {
                    println(it)
                    assertEquals(it, test.result)
                }
        }
    }
}
