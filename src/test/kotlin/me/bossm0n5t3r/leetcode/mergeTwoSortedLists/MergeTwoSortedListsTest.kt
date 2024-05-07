package me.bossm0n5t3r.leetcode.mergeTwoSortedLists

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MergeTwoSortedListsTest {
    private val mergeTwoSortedLists = MergeTwoSortedLists.Solution()
    private val listNodeUtil = ListNodeUtil()

    data class MergeTwoSortedListsTestData(
        val l1: ListNode?,
        val l2: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun mergeTwoLists() {
        val tests =
            listOf(
                MergeTwoSortedListsTestData(
                    listNodeUtil.generateListNode(1, 2, 4),
                    listNodeUtil.generateListNode(1, 3, 4),
                    listNodeUtil.generateListNode(1, 1, 2, 3, 4, 4),
                ),
                MergeTwoSortedListsTestData(
                    listNodeUtil.generateListNode(),
                    listNodeUtil.generateListNode(),
                    listNodeUtil.generateListNode(),
                ),
                MergeTwoSortedListsTestData(
                    listNodeUtil.generateListNode(),
                    listNodeUtil.generateListNode(0),
                    listNodeUtil.generateListNode(0),
                ),
            )
        tests.forEach { test ->
            assertTrue(listNodeUtil.isEqual(mergeTwoSortedLists.mergeTwoLists(test.l1, test.l2), test.result))
            assertTrue(listNodeUtil.isEqual(mergeTwoSortedLists.mergeTwoListsRecursive(test.l1, test.l2), test.result))
        }
    }
}
