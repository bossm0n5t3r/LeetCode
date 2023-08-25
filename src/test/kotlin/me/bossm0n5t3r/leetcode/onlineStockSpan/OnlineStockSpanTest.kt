package me.bossm0n5t3r.leetcode.onlineStockSpan

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OnlineStockSpanTest {
    private val sut = OnlineStockSpan.StockSpanner()

    @Test
    fun test() {
        assertEquals(sut.next(100), 1)
        assertEquals(sut.next(80), 1)
        assertEquals(sut.next(60), 1)
        assertEquals(sut.next(70), 2)
        assertEquals(sut.next(60), 1)
        assertEquals(sut.next(75), 4)
        assertEquals(sut.next(85), 6)
    }
}
