package factorialTrailingZeroes

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FactorialTrailingZeroesTest {
    private val factorialTrailingZeroes = FactorialTrailingZeroes()

    data class FactorialTrailingZeroesTestData(
        val n: Int,
        val result: Int
    )

    @Test
    fun trailingZeroes() {
        val tests = listOf(
            FactorialTrailingZeroesTestData(3, 0),
            FactorialTrailingZeroesTestData(5, 1),
            FactorialTrailingZeroesTestData(0, 0)
        )
        tests.forEach { test ->
            assertEquals(factorialTrailingZeroes.trailingZeroes(test.n), test.result)
        }
    }
}
