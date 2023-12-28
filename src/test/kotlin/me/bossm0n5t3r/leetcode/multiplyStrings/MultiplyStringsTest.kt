package me.bossm0n5t3r.leetcode.multiplyStrings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MultiplyStringsTest {
    private val sut = MultiplyStrings.Solution()

    private data class Example(
        val num1: String,
        val num2: String,
        val result: String,
    )

    @Test
    fun multiply() {
        val tests =
            listOf(
                Example("2", "3", "6"),
                Example("123", "456", "56088"),
            )
        tests.forEach { test ->
            assertEquals(sut.multiply(test.num1, test.num2), test.result)
        }
    }
}
