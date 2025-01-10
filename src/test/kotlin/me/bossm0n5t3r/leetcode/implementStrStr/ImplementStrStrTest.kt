package me.bossm0n5t3r.leetcode.implementStrStr

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ImplementStrStrTest {
    private val sut = ImplementStrStr.Solution()

    private data class ImplementStrStrTestData(
        val haystack: String,
        val needle: String,
        val result: Int,
    )

    @Test
    fun strStr() {
        val tests =
            listOf(
                ImplementStrStrTestData("hello", "ll", 2),
                ImplementStrStrTestData("aaaaa", "bba", -1),
                ImplementStrStrTestData("", "", 0),
                ImplementStrStrTestData("a", "a", 0),
                ImplementStrStrTestData("abc", "c", 2),
            )
        tests.forEach { test ->
            assertEquals(test.result, sut.strStr(test.haystack, test.needle))
            assertEquals(test.result, sut.strStrAt20250111(test.haystack, test.needle))
        }
    }
}
