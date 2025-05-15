package me.bossm0n5t3r.leetcode.countthenumberoffairpairs

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountTheNumberOfFairPairsTest {
    private val sut = CountTheNumberOfFairPairs.Solution()

    private data class TestData(
        val nums: IntArray,
        val lower: Int,
        val upper: Int,
        val result: Long,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (lower != other.lower) return false
            if (upper != other.upper) return false
            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = lower
            result1 = 31 * result1 + upper
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[0,1,7,4,4,5]".toIntArray(), 3, 6, 6),
                TestData("[1,7,9,2,5]".toIntArray(), 11, 11, 1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.countFairPairs(testData.nums, testData.lower, testData.upper),
            )
        }
    }
}
