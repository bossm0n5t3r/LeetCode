package me.bossm0n5t3r.leetcode.implementStrStr

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ImplementStrStrTest {
    private val implementStrStr = ImplementStrStr.Solution()

    data class ImplementStrStrTestData(
        val haystack: String,
        val needle: String,
        val result: Int,
    )

    @Test
    fun strStr() {
        val tests = listOf(
            ImplementStrStrTestData("hello", "ll", 2),
            ImplementStrStrTestData("aaaaa", "bba", -1),
            ImplementStrStrTestData("", "", 0),
            ImplementStrStrTestData("a", "a", 0),
            ImplementStrStrTestData("abc", "c", 2),
        )
        tests.forEach { test ->
            assertEquals(implementStrStr.strStr(test.haystack, test.needle), test.result)
        }
    }
}
