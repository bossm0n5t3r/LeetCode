package me.bossm0n5t3r.leetcode.oddEvenLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class OddEvenLinkedListTest {
    private val oddEvenLinkedList = OddEvenLinkedList.Solution()
    private val listNodeUtil = ListNodeUtil()

    data class OddEvenLinkedListTestData(
        val head: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun oddEvenList() {
        val tests =
            listOf(
                OddEvenLinkedListTestData(
                    head = listNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    result = listNodeUtil.generateListNode(1, 3, 5, 2, 4),
                ),
                OddEvenLinkedListTestData(
                    head = listNodeUtil.generateListNode(2, 1, 3, 5, 6, 4, 7),
                    result = listNodeUtil.generateListNode(2, 3, 6, 7, 1, 5, 4),
                ),
                OddEvenLinkedListTestData(
                    head = listNodeUtil.generateListNode(1, 2, 3, 4, 5, 6, 7, 8),
                    result = listNodeUtil.generateListNode(1, 3, 5, 7, 2, 4, 6, 8),
                ),
                OddEvenLinkedListTestData(
                    head = listNodeUtil.generateListNode(1, 1),
                    result = listNodeUtil.generateListNode(1, 1),
                ),
            )
        tests.forEach { test ->
            assertTrue(listNodeUtil.isEqual(oddEvenLinkedList.oddEvenList(test.head), test.result))
        }
    }
}
