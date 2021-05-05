package deleteNodeInALinkedList

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeleteNodeInALinkedListTest {
    private lateinit var deleteNodeInALinkedList: DeleteNodeInALinkedList

    data class DeleteNodeInALinkedListTestData(
        val head: ListNode?,
        val node: Int,
        val result: List<Int>
    )

    private fun generateHeadListNode(head: List<Int>): ListNode? {
        if (head.isEmpty()) return null
        val length = head.size
        val result = ListNode(head[0])
        var cur = result
        for (i in 1 until length) {
            cur.next = ListNode(head[i])
            cur = cur.next!!
        }
        return result
    }

    private fun findNodeByValue(value: Int, head: ListNode): ListNode {
        var cur = head
        while (cur.`val` != value) {
            cur = cur.next!!
        }
        return cur
    }

    private fun listNodeToList(listNode: ListNode): List<Int> {
        val result = mutableListOf<Int>()
        var cur: ListNode? = listNode
        while (cur != null) {
            result.add(cur.`val`)
            cur = cur.next
        }
        return result
    }

    @Test
    fun deleteNode() {
        val tests = listOf(
            DeleteNodeInALinkedListTestData(
                head = generateHeadListNode(listOf(4, 5, 1, 9)),
                node = 5,
                result = listOf(4, 1, 9)
            ),
            DeleteNodeInALinkedListTestData(
                head = generateHeadListNode(listOf(4, 5, 1, 9)),
                node = 1,
                result = listOf(4, 5, 9)
            ),
            DeleteNodeInALinkedListTestData(
                head = generateHeadListNode(listOf(1, 2, 3, 4)),
                node = 3,
                result = listOf(1, 2, 4)
            ),
            DeleteNodeInALinkedListTestData(
                head = generateHeadListNode(listOf(0, 1)),
                node = 0,
                result = listOf(1)
            ),
            DeleteNodeInALinkedListTestData(
                head = generateHeadListNode(listOf(-3, 5, -99)),
                node = -3,
                result = listOf(5, -99)
            ),
        )
        tests.forEach { test ->
            val node = findNodeByValue(test.node, test.head!!)
            deleteNodeInALinkedList = DeleteNodeInALinkedList(test.head)
            deleteNodeInALinkedList.deleteNode(node)
            assertEquals(listNodeToList(deleteNodeInALinkedList.head), test.result)
        }
    }
}
