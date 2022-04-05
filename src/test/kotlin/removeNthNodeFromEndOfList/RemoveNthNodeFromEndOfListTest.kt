package removeNthNodeFromEndOfList

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertTrue

internal class RemoveNthNodeFromEndOfListTest {
    private val removeNthNodeFromEndOfList = RemoveNthNodeFromEndOfList()
    private val listNodeUtil = ListNodeUtil()

    private data class RemoveNthNodeFromEndOfListTestData(
        val head: ListNode?,
        val n: Int,
        val result: ListNode?
    )

    @Test
    fun removeNthFromEnd() {
        val tests = listOf(
            RemoveNthNodeFromEndOfListTestData(
                listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4, 5)),
                2,
                listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 5))
            ),
            RemoveNthNodeFromEndOfListTestData(
                listNodeUtil.generateListNodeFromList(listOf(1)),
                1,
                listNodeUtil.generateListNodeFromList(listOf())
            ),
            RemoveNthNodeFromEndOfListTestData(
                listNodeUtil.generateListNodeFromList(listOf(1, 2)),
                1,
                listNodeUtil.generateListNodeFromList(listOf(1))
            ),
        )
        tests.forEach { test ->
            val result = removeNthNodeFromEndOfList.removeNthFromEnd(test.head, test.n)
            listNodeUtil.printListNode(result)
            assertTrue(listNodeUtil.isEqual(result, test.result))

            val resultUsingPointers = removeNthNodeFromEndOfList.removeNthFromEndUsingPointers(test.head, test.n)
            listNodeUtil.printListNode(resultUsingPointers)
            assertTrue(listNodeUtil.isEqual(resultUsingPointers, test.result))
        }
    }
}
