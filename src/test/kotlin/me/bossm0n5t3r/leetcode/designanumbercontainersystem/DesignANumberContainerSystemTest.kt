package me.bossm0n5t3r.leetcode.designanumbercontainersystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignANumberContainerSystemTest {
    @Test
    fun test0() {
        val sut = DesignANumberContainerSystem.NumberContainers()
        assertEquals(-1, sut.find(10))
        sut.change(2, 10)
        sut.change(1, 10)
        sut.change(3, 10)
        sut.change(5, 10)
        assertEquals(1, sut.find(10))
        sut.change(1, 20)
        assertEquals(2, sut.find(10))
    }

    @Test
    fun test1() {
        val sut = DesignANumberContainerSystem.NumberContainers()
        sut.change(25, 50)
        sut.change(56, 31)
        assertEquals(25, sut.find(50))
        assertEquals(25, sut.find(50))
        assertEquals(-1, sut.find(43))
        sut.change(30, 50)
        assertEquals(56, sut.find(31))
        assertEquals(-1, sut.find(43))
        sut.change(25, 20)
        assertEquals(30, sut.find(50))
        sut.change(56, 43)
        sut.change(68, 31)
        sut.change(56, 31)
        assertEquals(25, sut.find(20))
        assertEquals(-1, sut.find(43))
        sut.change(25, 43)
        assertEquals(25, sut.find(43))
        sut.change(56, 31)
        sut.change(54, 43)
        sut.change(63, 43)
    }
}
