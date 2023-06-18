package me.bossm0n5t3r.leetcode.palindromicSubstrings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PalindromicSubstringsTest {
    private val palindromicSubstrings = PalindromicSubstrings.Solution()

    private data class PalindromicSubstringsTestData(
        val s: String,
        val result: Int,
    )

    @Test
    fun countSubstrings() {
        val tests = listOf(
            PalindromicSubstringsTestData(
                "abc",
                3,
            ),
            PalindromicSubstringsTestData(
                "aaa",
                6,
            ),
        )
        tests.forEach { test ->
            palindromicSubstrings.countSubstrings(test.s)
                .also {
                    println(it)
                    assertEquals(it, test.result)
                }

            palindromicSubstrings.countSubstringsUsingDP(test.s)
                .also {
                    println(it)
                    assertEquals(it, test.result)
                }
        }
    }

    @Test
    fun isPalindromeTest() {
        assertThat(palindromicSubstrings.isPalindrome("a")).isTrue
        assertThat(palindromicSubstrings.isPalindrome("aba")).isTrue
        assertThat(palindromicSubstrings.isPalindrome("abcba")).isTrue
        assertThat(palindromicSubstrings.isPalindrome("aa")).isTrue

        assertThat(palindromicSubstrings.isPalindrome("ab")).isFalse
        assertThat(palindromicSubstrings.isPalindrome("ba")).isFalse
        assertThat(palindromicSubstrings.isPalindrome("aab")).isFalse
    }
}
