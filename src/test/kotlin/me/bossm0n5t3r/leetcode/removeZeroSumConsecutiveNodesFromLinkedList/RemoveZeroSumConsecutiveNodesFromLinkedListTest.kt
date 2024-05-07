package me.bossm0n5t3r.leetcode.removeZeroSumConsecutiveNodesFromLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class RemoveZeroSumConsecutiveNodesFromLinkedListTest {
    private val sut = RemoveZeroSumConsecutiveNodesFromLinkedList.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class TestData(
        val head: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    listNodeUtil.generateListNode(1, 2, -3, 3, 1),
                    listNodeUtil.generateListNode(3, 1),
                ),
                TestData(
                    listNodeUtil.generateListNode(1, 2, 3, -3, 4),
                    listNodeUtil.generateListNode(1, 2, 4),
                ),
                TestData(
                    listNodeUtil.generateListNode(1, 2, 3, -3, -2),
                    listNodeUtil.generateListNode(1),
                ),
                TestData(
                    listNodeUtil.generateListNode(1, 3, 2, -3, -2, 5, 5, -5, 1),
                    listNodeUtil.generateListNode(1, 5, 1),
                ),
                TestData(
                    listNodeUtil.generateListNode(0, 0),
                    listNodeUtil.generateListNode(),
                ),
                TestData(
                    listNodeUtil.generateListNode(-1, 1, 0, 1),
                    listNodeUtil.generateListNode(1),
                ),
                TestData(
                    listNodeUtil.generateListNode(2, 2, -2, 1, -1, -1),
                    listNodeUtil.generateListNode(2, -1),
                ),
                TestData(
                    listNodeUtil.generateListNode(-1, -2, 0, -1, 2, 2, -1, 1),
                    listNodeUtil.generateListNode(),
                ),
            )

        tests.forEach { test ->
            assertTrue(listNodeUtil.isEqual(sut.removeZeroSumSublists(test.head), test.result))
        }
    }
}
