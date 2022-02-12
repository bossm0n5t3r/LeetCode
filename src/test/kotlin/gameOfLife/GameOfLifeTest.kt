package gameOfLife

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    private val gameOfLife = GameOfLife()

    data class GameOfLifeTestData(
        val board: Array<IntArray>,
        val result: Array<IntArray>
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as GameOfLifeTestData

            if (!board.contentDeepEquals(other.board)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = board.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun gameOfLife() {
        val tests = listOf(
            GameOfLifeTestData(
                arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0)),
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 1), intArrayOf(0, 1, 0)),
            ),
            GameOfLifeTestData(
                arrayOf(intArrayOf(1, 1), intArrayOf(1, 0)),
                arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
            )
        )
        tests.forEach { test ->
            gameOfLife.gameOfLife(test.board)
            assertThat(test.board).isEqualTo(test.result)
        }
    }
}
