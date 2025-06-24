package me.bossm0n5t3r.leetcode.findallkdistantindicesinanarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindAllKDistantIndicesInAnArrayTest {
    private val sut = FindAllKDistantIndicesInAnArray.Solution()

    private data class TestData(
        val nums: IntArray,
        val key: Int,
        val k: Int,
        val result: List<Int>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (key != other.key) return false
            if (k != other.k) return false
            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = key
            result1 = 31 * result1 + k
            result1 = 31 * result1 + nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        // Example Testcases
        // [3,4,9,1,3,9,5] / 9 / 1 / [2,2,2,2,2] / 2 / 2
        val testDataList =
            listOf(
                TestData("[3,4,9,1,3,9,5]".toIntArray(), 9, 1, listOf(1, 2, 3, 4, 5, 6)),
                TestData("[2,2,2,2,2]".toIntArray(), 2, 2, listOf(0, 1, 2, 3, 4)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.findKDistantIndices(testData.nums, testData.key, testData.k),
            )
        }
    }
}
