package me.bossm0n5t3r.leetcode.decodeString

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DecodeStringTest {
    private val sut = DecodeString.Solution()

    private data class TestData(
        val s: String,
        val result: String,
    )

    @Test
    fun test() {
        val tests = listOf(
            TestData(
                s = "3[a]2[bc]",
                result = "aaabcbc",
            ),
            TestData(
                s = "3[a2[c]]",
                result = "accaccacc",
            ),
            TestData(
                s = "2[abc]3[cd]ef",
                result = "abcabccdcdcdef",
            ),
        )

        tests.forEach { test ->
            assertEquals(
                sut.decodeString(test.s),
                test.result,
            )
        }
    }
}
