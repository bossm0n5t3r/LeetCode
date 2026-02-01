package me.bossm0n5t3r.leetcode.insertDeleteGetRandomO1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertDeleteGetRandomO1Test {
    @Test
    fun test() {
        val randomizedSet = InsertDeleteGetRandomO1.RandomizedSet()
        assertEquals(true, randomizedSet.insert(1))
        assertEquals(false, randomizedSet.remove(2))
        assertEquals(true, randomizedSet.insert(2))
        assertThat(randomizedSet.getRandom()).isIn(1, 2)
        assertEquals(true, randomizedSet.remove(1))
        assertEquals(false, randomizedSet.insert(2))
        assertEquals(2, randomizedSet.getRandom())
    }
}
