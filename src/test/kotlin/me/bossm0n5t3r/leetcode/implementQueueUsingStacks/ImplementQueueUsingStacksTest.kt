package me.bossm0n5t3r.leetcode.implementQueueUsingStacks

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ImplementQueueUsingStacksTest {
    private val sut = ImplementQueueUsingStacks.MyQueue()

    @Test
    fun test() {
        sut.push(1)
        sut.push(2)
        assertEquals(1, sut.peek())
        assertEquals(1, sut.pop())
        assertFalse { sut.empty() }
    }
}
