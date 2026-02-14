package me.bossm0n5t3r.leetcode.champagnetower

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ChampagneTowerTest {
    private val sut = ChampagneTower.Solution()

    private data class TestData(
        val poured: Int,
        val queryRow: Int,
        val queryGlass: Int,
        val result: Double,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(1, 1, 1, 0.000),
                TestData(2, 1, 1, 0.500),
                TestData(100000009, 33, 17, 1.000),
                TestData(25, 6, 1, 0.18750),
                TestData(6, 2, 0, 0.75),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.champagneTower(testData.poured, testData.queryRow, testData.queryGlass),
            )
        }
    }
}
