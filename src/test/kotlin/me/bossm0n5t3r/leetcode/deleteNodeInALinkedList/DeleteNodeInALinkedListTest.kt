package me.bossm0n5t3r.leetcode.deleteNodeInALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeleteNodeInALinkedListTest {
    private lateinit var deleteNodeInALinkedList: DeleteNodeInALinkedList.Solution
    private val listNodeUtil = ListNodeUtil()

    data class DeleteNodeInALinkedListTestData(
        val head: ListNode?,
        val node: Int,
        val result: List<Int>,
    )

    @Test
    fun deleteNode() {
        val tests =
            listOf(
                DeleteNodeInALinkedListTestData(
                    head = listNodeUtil.generateListNodeFromList(listOf(4, 5, 1, 9)),
                    node = 5,
                    result = listOf(4, 1, 9),
                ),
                DeleteNodeInALinkedListTestData(
                    head = listNodeUtil.generateListNodeFromList(listOf(4, 5, 1, 9)),
                    node = 1,
                    result = listOf(4, 5, 9),
                ),
                DeleteNodeInALinkedListTestData(
                    head = listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4)),
                    node = 3,
                    result = listOf(1, 2, 4),
                ),
                DeleteNodeInALinkedListTestData(
                    head = listNodeUtil.generateListNodeFromList(listOf(0, 1)),
                    node = 0,
                    result = listOf(1),
                ),
                DeleteNodeInALinkedListTestData(
                    head = listNodeUtil.generateListNodeFromList(listOf(-3, 5, -99)),
                    node = -3,
                    result = listOf(5, -99),
                ),
            )
        tests.forEach { test ->
            val node = listNodeUtil.findListNodeByValue(test.node, test.head!!)
            deleteNodeInALinkedList = DeleteNodeInALinkedList.Solution(test.head)
            deleteNodeInALinkedList.deleteNode(node)
            assertEquals(listNodeUtil.listNodeToList(deleteNodeInALinkedList.head), test.result)
        }
    }
}
