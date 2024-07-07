package me.bossm0n5t3r.leetcode.waterBottles

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WaterBottlesTest {
    private val sut = WaterBottles.Solution()

    private data class TestData(val numBottles: Int, val numExchange: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(9, 3, 13),
                TestData(15, 4, 19),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.numWaterBottles(test.numBottles, test.numExchange),
            )
        }
    }
}
