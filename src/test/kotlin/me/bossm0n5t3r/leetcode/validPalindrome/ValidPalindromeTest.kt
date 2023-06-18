package me.bossm0n5t3r.leetcode.validPalindrome

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidPalindromeTest {
    private val validPalindrome = ValidPalindrome.Solution()

    data class ValidPalindromeTestData(
        val s: String,
        val result: Boolean,
    )

    @Test
    fun isPalindrome() {
        val tests = listOf(
            ValidPalindromeTestData("A man, a plan, a canal: Panama", true),
            ValidPalindromeTestData("race a car", false),
            ValidPalindromeTestData(" ", true),
            ValidPalindromeTestData("0P", false),
        )
        tests.forEach { test ->
            assertEquals(validPalindrome.isPalindrome(test.s), test.result)
        }
    }
}
