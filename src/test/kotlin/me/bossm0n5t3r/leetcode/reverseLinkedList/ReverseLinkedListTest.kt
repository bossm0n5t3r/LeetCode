package me.bossm0n5t3r.leetcode.reverseLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseLinkedListTest {
    private val reverseLinkedList = ReverseLinkedList.Solution()

    data class ReverseLinkedListTestData(
        val head: ListNode?,
        val result: List<Int>?,
    )

    @Test
    fun reverseList() {
        val tests =
            listOf(
                ReverseLinkedListTestData(
                    head = ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    result = listOf(5, 4, 3, 2, 1),
                ),
                ReverseLinkedListTestData(
                    head = ListNodeUtil.generateListNode(1, 2),
                    result = listOf(2, 1),
                ),
                ReverseLinkedListTestData(
                    head = ListNodeUtil.generateListNode(),
                    result = listOf(),
                ),
            )
        tests.forEach { test ->
            assertEquals(ListNodeUtil.listNodeToList(reverseLinkedList.reverseList(test.head)), test.result)
        }
    }
}
