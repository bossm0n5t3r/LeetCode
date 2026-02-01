package me.bossm0n5t3r.leetcode.convert1dArrayInto2dArray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Convert1dArrayInto2dArrayTest {
    private val sut = Convert1dArrayInto2dArray.Solution()

    private data class TestData(
        val original: IntArray,
        val m: Int,
        val n: Int,
        val result: Array<IntArray>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!original.contentEquals(other.original)) return false
            if (m != other.m) return false
            if (n != other.n) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = original.contentHashCode()
            result1 = 31 * result1 + m
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 3, 4), 2, 2, "[[1,2],[3,4]]".toArrayOfIntArray()),
                TestData(intArrayOf(1, 2, 3), 1, 3, "[[1,2,3]]".toArrayOfIntArray()),
                TestData(intArrayOf(1, 2), 1, 1, "[]".toArrayOfIntArray()),
            )

        tests.forEach { test ->
            assertTrue {
                sut.construct2DArray(test.original, test.m, test.n).contentDeepEquals(test.result)
            }
        }
    }
}
