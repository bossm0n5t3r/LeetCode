package me.bossm0n5t3r.leetcode.minimumWindowSubstring

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumWindowSubstringTest {
    private val sut = MinimumWindowSubstring.Solution()

    private data class TestData(
        val s: String,
        val t: String,
        val result: String,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("ADOBECODEBANC", "ABC", "BANC"),
                TestData("a", "a", "a"),
                TestData("a", "aa", ""),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.minWindow(test.s, test.t),
            )
        }
    }
}
