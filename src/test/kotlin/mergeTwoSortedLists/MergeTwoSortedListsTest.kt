package mergeTwoSortedLists

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertTrue

class MergeTwoSortedListsTest {
    private val mergeTwoSortedLists = MergeTwoSortedLists()
    private val listNodeUtil = ListNodeUtil()

    data class MergeTwoSortedListsTestData(
        val l1: ListNode?,
        val l2: ListNode?,
        val result: ListNode?
    )

    @Test
    fun mergeTwoLists() {
        val tests = listOf(
            MergeTwoSortedListsTestData(
                listNodeUtil.generateListNodeFromList(listOf(1, 2, 4)),
                listNodeUtil.generateListNodeFromList(listOf(1, 3, 4)),
                listNodeUtil.generateListNodeFromList(listOf(1, 1, 2, 3, 4, 4))
            ),
            MergeTwoSortedListsTestData(
                listNodeUtil.generateListNodeFromList(listOf()),
                listNodeUtil.generateListNodeFromList(listOf()),
                listNodeUtil.generateListNodeFromList(listOf())
            ),
            MergeTwoSortedListsTestData(
                listNodeUtil.generateListNodeFromList(listOf()),
                listNodeUtil.generateListNodeFromList(listOf(0)),
                listNodeUtil.generateListNodeFromList(listOf(0))
            )
        )
        tests.forEach { test ->
            assertTrue(listNodeUtil.isEqual(mergeTwoSortedLists.mergeTwoLists(test.l1, test.l2), test.result))
        }
    }
}
