package me.bossm0n5t3r.leetcode.longestsquarestreakinanarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSquareStreakInAnArrayTest {
    private val sut = LongestSquareStreakInAnArray.Solution()

    private data class TestData(
        val nums: IntArray,
        val result: Int,
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
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[4,3,6,16,8,2]".toIntArray(), 3),
                TestData("[2,3,5,6,7]".toIntArray(), -1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.longestSquareStreak(testData.nums),
            )
        }
    }
}
