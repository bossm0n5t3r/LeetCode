package me.bossm0n5t3r.leetcode.reverseVowelsOfAString

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseVowelsOfAStringTest {
    private val sut = ReverseVowelsOfAString.Solution()

    private data class TestData(
        val s: String,
        val result: String,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("hello", "holle"),
                TestData("leetcode", "leotcede"),
            )
        tests.forEach { test ->
            assertEquals(
                sut.reverseVowels(test.s),
                test.result,
            )
        }
    }
}
