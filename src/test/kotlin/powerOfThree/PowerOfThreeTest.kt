package powerOfThree

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PowerOfThreeTest {
    private val powerOfThree = PowerOfThree()

    data class PowerOfThreeTestData(
        val n: Int,
        val result: Boolean,
    )

    @Test
    fun isPowerOfThree() {
        val tests = listOf(
            PowerOfThreeTestData(27, true),
            PowerOfThreeTestData(0, false),
            PowerOfThreeTestData(9, true),
            PowerOfThreeTestData(45, false),
            PowerOfThreeTestData(-3, false),

        )
        tests.forEach { test ->
            assertEquals(powerOfThree.isPowerOfThree(test.n), test.result)
            assertEquals(powerOfThree.isPowerOfThreeUsingMathematics(test.n), test.result)
        }
    }
}
