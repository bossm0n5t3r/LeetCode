package me.bossm0n5t3r.leetcode.smallestNumberInInfiniteSet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestNumberInInfiniteSetTest {
    @Test
    fun test() {
        val sut = SmallestNumberInInfiniteSet.SmallestInfiniteSet()

        assertEquals(sut.addBack(2), Unit)
        assertEquals(sut.popSmallest(), 1)
        assertEquals(sut.popSmallest(), 2)
        assertEquals(sut.popSmallest(), 3)
        assertEquals(sut.addBack(1), Unit)
        assertEquals(sut.popSmallest(), 1)
        assertEquals(sut.popSmallest(), 4)
        assertEquals(sut.popSmallest(), 5)
    }
}
