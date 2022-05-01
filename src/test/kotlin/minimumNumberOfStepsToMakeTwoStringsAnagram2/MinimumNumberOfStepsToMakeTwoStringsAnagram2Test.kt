package minimumNumberOfStepsToMakeTwoStringsAnagram2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MinimumNumberOfStepsToMakeTwoStringsAnagram2Test {
    private val minimumNumberOfStepsToMakeTwoStringsAnagram2 = MinimumNumberOfStepsToMakeTwoStringsAnagram2()

    private data class MinimumNumberOfStepsToMakeTwoStringsAnagram2TestData(
        val s: String,
        val t: String,
        val result: Int
    )

    @Test
    fun minSteps() {
        val tests = listOf(
            MinimumNumberOfStepsToMakeTwoStringsAnagram2TestData(
                "leetcode", "coats", 7
            ),
            MinimumNumberOfStepsToMakeTwoStringsAnagram2TestData(
                "night", "thing", 0
            ),
        )
        tests.forEach { test ->
            val result = minimumNumberOfStepsToMakeTwoStringsAnagram2.minSteps(test.s, test.t)
            println(result)
            assertEquals(result, test.result)
        }
    }
}
