package me.bossm0n5t3r.leetcode.numberOfWonderfulSubstrings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfWonderfulSubstringsTest {
    private val sut = NumberOfWonderfulSubstrings.Solution()

    private data class TestData(
        val word: String,
        val result: Long,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("aba", 4),
                TestData("aabb", 9),
                TestData("he", 2),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.wonderfulSubstrings(test.word),
            )
        }
    }
}
