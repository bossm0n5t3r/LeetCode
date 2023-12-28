package me.bossm0n5t3r.leetcode.mergeSortedArray

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MergeSortedArrayTest {
    private val mergeSortedArray = MergeSortedArray.Solution()

    data class MergeSortedArrayTestData(
        val nums1: IntArray,
        val m: Int,
        val nums2: IntArray,
        val n: Int,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MergeSortedArrayTestData

            if (!nums1.contentEquals(other.nums1)) return false
            if (m != other.m) return false
            if (!nums2.contentEquals(other.nums2)) return false
            if (n != other.n) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums1.contentHashCode()
            result1 = 31 * result1 + m
            result1 = 31 * result1 + nums2.contentHashCode()
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun merge() {
        val tests =
            listOf(
                MergeSortedArrayTestData(
                    intArrayOf(1, 2, 3, 0, 0, 0),
                    3,
                    intArrayOf(2, 5, 6),
                    3,
                    intArrayOf(1, 2, 2, 3, 5, 6),
                ),
                MergeSortedArrayTestData(intArrayOf(1), 1, intArrayOf(), 0, intArrayOf(1)),
                MergeSortedArrayTestData(intArrayOf(2, 0), 1, intArrayOf(1), 1, intArrayOf(1, 2)),
            )
        tests.forEach { test ->
            mergeSortedArray.merge(test.nums1, test.m, test.nums2, test.n)
            assertTrue(test.nums1.contentEquals(test.result))
        }
    }
}
