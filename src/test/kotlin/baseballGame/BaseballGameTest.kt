package baseballGame

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BaseballGameTest {
    private val baseballGame = BaseballGame()

    private data class BaseballGameTestData(
        val ops: Array<String>,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as BaseballGameTestData

            if (!ops.contentEquals(other.ops)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = ops.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun calPoints() {
        val tests = listOf(
            BaseballGameTestData(arrayOf("5", "2", "C", "D", "+"), 30),
            BaseballGameTestData(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+"), 27),
            BaseballGameTestData(arrayOf("1"), 1),
        )
        tests.forEach { test ->
            val result = baseballGame.calPoints(test.ops)
            println(result)
            assertEquals(result, test.result)
        }
    }
}
