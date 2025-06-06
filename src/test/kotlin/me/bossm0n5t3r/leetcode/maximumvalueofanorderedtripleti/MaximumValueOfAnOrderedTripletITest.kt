package me.bossm0n5t3r.leetcode.maximumvalueofanorderedtripleti

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumValueOfAnOrderedTripletITest {
    private val sut = MaximumValueOfAnOrderedTripletI.Solution()

    private data class TestData(
        val nums: IntArray,
        val result: Long,
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
            var result1 = result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[12,6,1,2,7]".toIntArray(), 77L),
                TestData("[1,10,3,4,19]".toIntArray(), 133L),
                TestData("[1,2,3]".toIntArray(), 0L),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maximumTripletValue(testData.nums),
            )
        }
    }
}
