package me.bossm0n5t3r.leetcode.mergetwo2darraysbysummingvalues

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MergeTwo2dArraysBySummingValuesTest {
    private val sut = MergeTwo2dArraysBySummingValues.Solution()

    private data class TestData(
        val nums1: Array<IntArray>,
        val nums2: Array<IntArray>,
        val result: Array<IntArray>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums1.contentDeepEquals(other.nums1)) return false
            if (!nums2.contentDeepEquals(other.nums2)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums1.contentDeepHashCode()
            result1 = 31 * result1 + nums2.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,2],[2,3],[4,5]]".toArrayOfIntArray(),
                    "[[1,4],[3,2],[4,1]]".toArrayOfIntArray(),
                    "[[1,6],[2,3],[3,2],[4,6]]".toArrayOfIntArray(),
                ),
                TestData(
                    "[[2,4],[3,6],[5,5]]".toArrayOfIntArray(),
                    "[[1,3],[4,3]]".toArrayOfIntArray(),
                    "[[1,3],[2,4],[3,6],[4,3],[5,5]]".toArrayOfIntArray(),
                ),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentDeepEquals(sut.mergeArrays(testData.nums1, testData.nums2))
            }
        }
    }
}
