package me.bossm0n5t3r.leetcode.maximumnumberofmovesinagrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumNumberOfMovesInAGridTest {
    private val sut = MaximumNumberOfMovesInAGrid.Solution()

    private data class TestData(
        val grid: Array<IntArray>,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]".toArrayOfIntArray(), 3),
                TestData("[[3,2,4],[2,1,9],[1,1,7]]".toArrayOfIntArray(), 0),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maxMoves(testData.grid),
            )
        }
    }
}
