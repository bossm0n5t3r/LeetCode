package me.bossm0n5t3r.leetcode.romanToInteger

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RomanToIntegerTest {
    private val romanToInteger = RomanToInteger.Solution()

    data class RomanToIntegerTestData(
        val s: String,
        val result: Int,
    )

    @Test
    fun romanToInt() {
        val tests = listOf(
            RomanToIntegerTestData("III", 3),
            RomanToIntegerTestData("IX", 9),
            RomanToIntegerTestData("LVIII", 58),
            RomanToIntegerTestData("MCMXCIV", 1994),
            RomanToIntegerTestData("III", 3),
        )
        tests.forEach { test ->
            assertEquals(romanToInteger.romanToInt(test.s), test.result)
        }
    }
}
