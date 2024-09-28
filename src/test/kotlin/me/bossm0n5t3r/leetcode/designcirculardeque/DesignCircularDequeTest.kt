package me.bossm0n5t3r.leetcode.designcirculardeque

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DesignCircularDequeTest {
    @Test
    fun test() {
        val sut = DesignCircularDeque.MyCircularDeque(3)

        assertThat(sut.insertLast(1)).isTrue()
        assertThat(sut.insertLast(2)).isTrue()
        assertThat(sut.insertFront(3)).isTrue()
        assertThat(sut.insertFront(4)).isFalse()
        assertThat(sut.getRear()).isEqualTo(2)
        assertThat(sut.isFull()).isTrue()
        assertThat(sut.deleteLast()).isTrue()
        assertThat(sut.insertFront(4)).isTrue()
        assertThat(sut.getFront()).isEqualTo(4)
    }
}
