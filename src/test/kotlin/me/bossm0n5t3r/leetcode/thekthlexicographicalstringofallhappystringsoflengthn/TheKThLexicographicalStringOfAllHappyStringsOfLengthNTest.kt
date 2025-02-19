package me.bossm0n5t3r.leetcode.thekthlexicographicalstringofallhappystringsoflengthn

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TheKThLexicographicalStringOfAllHappyStringsOfLengthNTest {
    private val sut = TheKThLexicographicalStringOfAllHappyStringsOfLengthN.Solution()

    private data class TestData(
        val n: Int,
        val k: Int,
        val result: String,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(1, 3, "C"),
                TestData(1, 4, ""),
                TestData(3, 9, "cab"),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.getHappyString(testData.n, testData.k),
            )
        }
    }
}
