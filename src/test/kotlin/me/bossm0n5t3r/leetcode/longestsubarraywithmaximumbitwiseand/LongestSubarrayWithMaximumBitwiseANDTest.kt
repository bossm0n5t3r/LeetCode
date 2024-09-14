package me.bossm0n5t3r.leetcode.longestsubarraywithmaximumbitwiseand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSubarrayWithMaximumBitwiseANDTest {
    private val sut = LongestSubarrayWithMaximumBitwiseAND.Solution()

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
                TestData(intArrayOf(1, 2, 3, 3, 2, 2), 2),
                TestData(intArrayOf(1, 2, 3, 4), 1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.longestSubarray(testData.nums),
            )
        }
    }
}
