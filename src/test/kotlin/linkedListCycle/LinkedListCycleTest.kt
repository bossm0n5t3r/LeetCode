package linkedListCycle

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertEquals

class LinkedListCycleTest {
    private val linkedListCycle = LinkedListCycle()
    private val listNodeUtil = ListNodeUtil()
    private val basicListNode = listNodeUtil.generateBasicSingleListNode()

    data class LinkedListCycleTestData(
        val head: List<ListNode?>,
        val result: Boolean
    )

    @Test
    fun hasCycle() {
        val tests = listOf(
            LinkedListCycleTestData(
                head = listOf(
                    basicListNode[0][3],
                    basicListNode[0][2],
                    basicListNode[0][0],
                    basicListNode[0][4],
                    basicListNode[0][2]
                ),
                result = true
            ),
            LinkedListCycleTestData(
                head = listOf(
                    basicListNode[0][1],
                    basicListNode[0][2],
                    basicListNode[0][1]
                ),
                result = true
            ),
            LinkedListCycleTestData(
                head = listOf(
                    basicListNode[0][1]
                ),
                result = false
            )
        )
        tests.forEach { test ->
            val head = listNodeUtil.connectListNode(test.head)
            assertEquals(
                linkedListCycle.hasCycleFirstApproach(head),
                test.result
            )
            assertEquals(
                linkedListCycle.hasCycleSecondApproach(head),
                test.result
            )
            listNodeUtil.clearBasicSingleListNode(basicListNode)
        }
    }
}
