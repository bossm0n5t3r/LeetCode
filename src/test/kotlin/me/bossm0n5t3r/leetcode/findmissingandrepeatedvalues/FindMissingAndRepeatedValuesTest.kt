package me.bossm0n5t3r.leetcode.findmissingandrepeatedvalues

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class FindMissingAndRepeatedValuesTest {
    private val sut = FindMissingAndRepeatedValues.Solution()

    private data class TestData(
        val grid: Array<IntArray>,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,3],[2,2]]".toArrayOfIntArray(), "[2,4]".toIntArray()),
                TestData("[[9,1,7],[8,9,2],[3,4,6]]".toArrayOfIntArray(), "[9,5]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.findMissingAndRepeatedValues(testData.grid))
            }
        }
    }
}
