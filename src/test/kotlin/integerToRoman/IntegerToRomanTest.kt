package integerToRoman

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class IntegerToRomanTest {
    private val integerToRoman = IntegerToRoman()

    private data class IntegerToRomanTestData(
        val num: Int,
        val result: String,
    )

    @Test
    fun intToRoman() {
        val tests = listOf(
            IntegerToRomanTestData(3, "III"),
            IntegerToRomanTestData(4, "IV"),
            IntegerToRomanTestData(9, "IX"),
            IntegerToRomanTestData(58, "LVIII"),
            IntegerToRomanTestData(1994, "MCMXCIV"),
            IntegerToRomanTestData(3999, "MMMCMXCIX"),
        )
        tests.forEach { test ->
            println(integerToRoman.intToRoman(test.num))
            assertEquals(integerToRoman.intToRoman(test.num), test.result)
        }
    }
}
