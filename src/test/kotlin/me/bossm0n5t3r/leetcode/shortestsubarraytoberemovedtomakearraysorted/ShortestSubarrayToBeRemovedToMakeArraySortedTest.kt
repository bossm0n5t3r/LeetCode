package me.bossm0n5t3r.leetcode.shortestsubarraytoberemovedtomakearraysorted

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ShortestSubarrayToBeRemovedToMakeArraySortedTest {
    private val sut = ShortestSubarrayToBeRemovedToMakeArraySorted.Solution()

    private data class TestData(
        val arr: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!arr.contentEquals(other.arr)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + arr.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,2,3,10,4,2,3,5]".toIntArray(), 3),
                TestData("[5,4,3,2,1]".toIntArray(), 4),
                TestData("[1,2,3]".toIntArray(), 0),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.findLengthOfShortestSubarray(testData.arr),
            )
        }
    }
}