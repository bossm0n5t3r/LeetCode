package reverseLinkedList

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertEquals

class ReverseLinkedListTest {
    private val reverseLinkedList = ReverseLinkedList()
    private val listNodeUtil = ListNodeUtil()

    data class ReverseLinkedListTestData(
        val head: ListNode?,
        val result: List<Int>?
    )

    @Test
    fun reverseList() {
        val tests = listOf(
            ReverseLinkedListTestData(
                head = listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4, 5)),
                result = listOf(5, 4, 3, 2, 1)
            ),
            ReverseLinkedListTestData(
                head = listNodeUtil.generateListNodeFromList(listOf(1, 2)),
                result = listOf(2, 1)
            ),
            ReverseLinkedListTestData(
                head = listNodeUtil.generateListNodeFromList(listOf()),
                result = listOf()
            )
        )
        tests.forEach { test ->
            assertEquals(listNodeUtil.listNodeToList(reverseLinkedList.reverseList(test.head)), test.result)
        }
    }
}
