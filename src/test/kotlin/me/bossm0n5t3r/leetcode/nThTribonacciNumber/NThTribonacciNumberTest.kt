package me.bossm0n5t3r.leetcode.nThTribonacciNumber

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NThTribonacciNumberTest {
    private val sut = NThTribonacciNumber.Solution()

    private data class TestData(
        val n: Int,
        val result: Int,
    )

    @Test
    fun test() {
        val tests = listOf(
            TestData(4, 4),
            TestData(25, 1389537),
        )

        tests.forEach { test ->
            assertEquals(
                sut.tribonacci(test.n),
                test.result,
            )
        }
    }
}
