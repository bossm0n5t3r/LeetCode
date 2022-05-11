package removeAllAdjacentDuplicatesInString

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RemoveAllAdjacentDuplicatesInStringTest {
    private val removeAllAdjacentDuplicatesInString = RemoveAllAdjacentDuplicatesInString()

    private data class RemoveAllAdjacentDuplicatesInStringTestData(
        val s: String,
        val result: String
    )

    @Test
    fun removeDuplicates() {
        val tests = listOf(
            RemoveAllAdjacentDuplicatesInStringTestData("abbaca", "ca"),
            RemoveAllAdjacentDuplicatesInStringTestData("azxxzy", "ay"),
        )
        tests.forEach { test ->
            val result = removeAllAdjacentDuplicatesInString.removeDuplicates(test.s)
            println(result)
            assertEquals(result, test.result)

            val resultUsingTwoPointers = removeAllAdjacentDuplicatesInString.removeDuplicatesUsingTwoPointers(test.s)
            println(resultUsingTwoPointers)
            assertEquals(resultUsingTwoPointers, test.result)
        }
    }
}
