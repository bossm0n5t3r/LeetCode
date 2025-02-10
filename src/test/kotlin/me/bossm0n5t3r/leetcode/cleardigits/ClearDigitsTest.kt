package me.bossm0n5t3r.leetcode.cleardigits

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ClearDigitsTest {
    private val sut = ClearDigits.Solution()

    private data class TestData(
        val s: String,
        val result: String,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abc", "abc"),
                TestData("cb34", ""),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.clearDigits(testData.s),
            )
        }
    }
}
