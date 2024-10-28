package me.bossm0n5t3r.leetcode.findthemaximumfactorscoreofarray

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTheMaximumFactorScoreOfArrayTest {
    private val sut = FindTheMaximumFactorScoreOfArray.Solution()

    private data class TestData(
        val nums: IntArray,
        val result: Long,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 4, 8, 16), 64),
                TestData(intArrayOf(1, 2, 3, 4, 5), 60),
                TestData(intArrayOf(3), 9),
                TestData(intArrayOf(4, 20, 4, 6, 15), 120),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maxScore(testData.nums),
            )
        }
    }
}
