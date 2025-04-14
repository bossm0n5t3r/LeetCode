package me.bossm0n5t3r.leetcode.countgoodtriplets

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountGoodTripletsTest {
    private val sut = CountGoodTriplets.Solution()

    private data class TestData(
        val arr: IntArray,
        val a: Int,
        val b: Int,
        val c: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (a != other.a) return false
            if (b != other.b) return false
            if (c != other.c) return false
            if (result != other.result) return false
            if (!arr.contentEquals(other.arr)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = a
            result1 = 31 * result1 + b
            result1 = 31 * result1 + c
            result1 = 31 * result1 + result
            result1 = 31 * result1 + arr.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[3,0,1,1,9,7]".toIntArray(), 7, 2, 3, 4),
                TestData("[1,1,2,2,3]".toIntArray(), 0, 0, 1, 0),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.countGoodTriplets(testData.arr, testData.a, testData.b, testData.c),
            )
        }
    }
}
