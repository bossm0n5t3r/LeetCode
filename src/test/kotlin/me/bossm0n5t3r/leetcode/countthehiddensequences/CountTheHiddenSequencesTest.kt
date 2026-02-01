package me.bossm0n5t3r.leetcode.countthehiddensequences

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheHiddenSequencesTest {
    private val sut = CountTheHiddenSequences.Solution()

    private data class TestData(
        val differences: IntArray,
        val lower: Int,
        val upper: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (lower != other.lower) return false
            if (upper != other.upper) return false
            if (result != other.result) return false
            if (!differences.contentEquals(other.differences)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = lower
            result1 = 31 * result1 + upper
            result1 = 31 * result1 + result
            result1 = 31 * result1 + differences.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,-3,4]".toIntArray(), 1, 6, 2),
                TestData("[3,-4,5,1,-2]".toIntArray(), -4, 5, 4),
                TestData("[4,-7,2]".toIntArray(), 3, 6, 0),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.numberOfArrays(testData.differences, testData.lower, testData.upper),
            )
        }
    }
}
