package intersectionOfTwoLinkedLists

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertEquals

class IntersectionOfTwoLinkedListsTest {
    private val intersectionOfTwoLinkedLists = IntersectionOfTwoLinkedLists()
    private val listNodeUtil = ListNodeUtil()
    private val basicSingleListNode = listNodeUtil.generateBasicSingleListNode()

    data class IntersectionOfTwoLinkedListsTestData(
        val headA: List<ListNode?>,
        val headB: List<ListNode?>,
        val result: ListNode?
    )

    @Test
    fun getIntersectionNode() {
        val tests = listOf(
            IntersectionOfTwoLinkedListsTestData(
                headA = listOf(
                    basicSingleListNode[1][4],
                    basicSingleListNode[1][1],
                    basicSingleListNode[0][8],
                    basicSingleListNode[0][4],
                    basicSingleListNode[0][5],
                ),
                headB = listOf(
                    basicSingleListNode[2][5],
                    basicSingleListNode[2][6],
                    basicSingleListNode[2][1],
                    basicSingleListNode[0][8],
                    basicSingleListNode[0][4],
                    basicSingleListNode[0][5],
                ),
                result = basicSingleListNode[0][8]
            ),
            IntersectionOfTwoLinkedListsTestData(
                headA = listOf(
                    basicSingleListNode[1][1],
                    basicSingleListNode[1][9],
                    basicSingleListNode[2][1],
                    basicSingleListNode[0][2],
                    basicSingleListNode[0][4],
                ),
                headB = listOf(
                    basicSingleListNode[2][3],
                    basicSingleListNode[0][2],
                    basicSingleListNode[0][4]
                ),
                result = basicSingleListNode[0][2]
            ),
            IntersectionOfTwoLinkedListsTestData(
                headA = listOf(
                    basicSingleListNode[0][2],
                    basicSingleListNode[0][6],
                    basicSingleListNode[0][4]
                ),
                headB = listOf(
                    basicSingleListNode[0][1],
                    basicSingleListNode[0][5]
                ),
                result = null
            ),
        )
        tests.forEach { test ->
            val headA = listNodeUtil.connectListNode(test.headA)
            val headB = listNodeUtil.connectListNode(test.headB)
            assertEquals(
                intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB),
                test.result
            )
            listNodeUtil.clearBasicSingleListNode(basicSingleListNode)
        }
    }
}
