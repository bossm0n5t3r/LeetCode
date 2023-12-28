package me.bossm0n5t3r.leetcode.zigzagConversion

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ZigzagConversionTest {
    private val zigzagConversion = ZigzagConversion.Solution()

    private data class ZigzagConversionTestData(
        val s: String,
        val numRows: Int,
        val result: String,
    )

    @Test
    fun convert() {
        val tests =
            listOf(
                ZigzagConversionTestData("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                ZigzagConversionTestData("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                ZigzagConversionTestData("A", 1, "A"),
                ZigzagConversionTestData("AB", 1, "AB"),
            )
        tests.forEach { test ->
            println(zigzagConversion.convert(test.s, test.numRows))
            assertEquals(zigzagConversion.convert(test.s, test.numRows), test.result)
        }
    }
}
