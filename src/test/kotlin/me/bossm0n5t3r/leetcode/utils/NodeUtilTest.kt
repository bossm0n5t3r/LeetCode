package me.bossm0n5t3r.leetcode.utils

import me.bossm0n5t3r.leetcode.utils.NodeUtil.toList
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertEquals

class NodeUtilTest {
    @Test
    fun generateNodeOrNullTest() {
        //         1
        //         │
        //     ┌───┼───┐
        //     │   │   │
        //     3   2   4
        //     │
        //    ┌┴┐
        //    │ │
        //    5 6
        val values = listOf(1, null, 3, 2, 4, null, 5, 6)
        val result =
            assertDoesNotThrow {
                NodeUtil.generateNodeOrNull(*values.toTypedArray())
            }
        assertEquals(
            values,
            result?.toList(),
        )
    }
}
