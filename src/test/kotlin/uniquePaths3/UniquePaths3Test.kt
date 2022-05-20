package uniquePaths3

import org.junit.jupiter.api.Test
import utils.MatrixUtil
import kotlin.test.assertEquals

internal class UniquePaths3Test {
    private val uniquePaths3 = UniquePaths3()
    private val matrixUtil = MatrixUtil()

    private data class UniquePaths3TestData(
        val grid: Array<IntArray>,
        val result: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as UniquePaths3TestData

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
    fun uniquePathsIII() {
        val tests = listOf(
            UniquePaths3TestData(
                matrixUtil.generateMatrixFrom("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]"),
                2,
            ),
            UniquePaths3TestData(
                matrixUtil.generateMatrixFrom("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]"),
                4,
            ),
            UniquePaths3TestData(
                matrixUtil.generateMatrixFrom("[[0,1],[2,0]]"),
                0,
            ),
        )
        tests.forEach { test ->
            uniquePaths3.uniquePathsIII(test.grid)
                .also {
                    println(it)
                    assertEquals(it, test.result)
                }
        }
    }
}
