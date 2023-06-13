package stringToInteger

import org.junit.jupiter.api.Test
import stringToInteger.StringToInteger.Companion.step3
import kotlin.test.assertEquals

internal class StringToIntegerTest {
    private val stringToInteger = StringToInteger()

    private data class StringToIntegerTestData(
        val s: String,
        val result: Int,
    )

    @Test
    fun myAtoi() {
        val tests = listOf(
            StringToIntegerTestData(
                "42",
                42,
            ),
            StringToIntegerTestData(
                "   -42",
                -42,
            ),
            StringToIntegerTestData(
                "4193 with words",
                4193,
            ),
            StringToIntegerTestData(
                "-91283472332",
                -2147483648,
            ),
            StringToIntegerTestData(
                "+1",
                1,
            ),
            StringToIntegerTestData(
                "20000000000000000000",
                2147483647,
            ),
        )
        tests.forEach { test ->
            println(stringToInteger.myAtoi(test.s))
            assertEquals(stringToInteger.myAtoi(test.s), test.result)
        }
    }

    @Test
    fun step3Test() {
        assertEquals(Pair('+', "123121").step3(), Pair('+', "123121"))
        assertEquals(Pair('+', "tests123121").step3(), Pair('+', ""))
        assertEquals(Pair('+', "     123121").step3(), Pair('+', ""))
    }
}
