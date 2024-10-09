package me.bossm0n5t3r.leetcode.minimumaddtomakeparenthesesvalid

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumAddToMakeParenthesesValidTest {
    private val sut = MinimumAddToMakeParenthesesValid.Solution()

    private data class TestData(
        val s: String,
        val result: Int,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("())", 1),
                TestData("(((", 3),
                TestData("()))((", 4),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.minAddToMakeValid(testData.s),
            )
        }
    }
}
