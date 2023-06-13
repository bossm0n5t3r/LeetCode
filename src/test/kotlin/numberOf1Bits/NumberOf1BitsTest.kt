package numberOf1Bits

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOf1BitsTest {
    private val numberOf1Bits = NumberOf1Bits()

    data class NumberOf1BitsTestData(
        val n: Int,
        val result: Int,
    )

    @Test
    fun hammingWeight() {
        val tests = listOf(
            NumberOf1BitsTestData(11, 3),
            NumberOf1BitsTestData(128, 1),
            NumberOf1BitsTestData(-3, 31),
            NumberOf1BitsTestData(0, 0),
        )
        tests.forEach { test ->
            assertEquals(numberOf1Bits.hammingWeight(test.n), test.result)
        }
    }
}
