package me.bossm0n5t3r.leetcode.countcompletesubarraysinanarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountCompleteSubarraysInAnArrayTest {
    private val sut = CountCompleteSubarraysInAnArray.Solution()

    private data class TestData(
        val nums: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,3,1,2,2]".toIntArray(), 4),
                TestData("[5,5,5,5]".toIntArray(), 10),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.countCompleteSubarrays(testData.nums),
            )
        }
    }
}
