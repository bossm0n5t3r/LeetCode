package me.bossm0n5t3r.leetcode.findifarraycanbesorted

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindIfArrayCanBeSortedTest {
    private val sut = FindIfArrayCanBeSorted.Solution()

    private data class TestData(
        val nums: IntArray,
        val result: Boolean,
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
                TestData("[8,4,2,30,15]".toIntArray(), true),
                TestData("[1,2,3,4,5]".toIntArray(), true),
                TestData("[3,16,8,4,2]".toIntArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.canSortArray(testData.nums),
            )
        }
    }
}
