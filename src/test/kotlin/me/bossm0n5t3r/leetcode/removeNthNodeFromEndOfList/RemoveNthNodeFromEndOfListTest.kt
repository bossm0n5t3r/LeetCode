package me.bossm0n5t3r.leetcode.removeNthNodeFromEndOfList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class RemoveNthNodeFromEndOfListTest {
    private val removeNthNodeFromEndOfList = RemoveNthNodeFromEndOfList.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class RemoveNthNodeFromEndOfListTestData(
        val head: ListNode?,
        val n: Int,
        val result: ListNode?,
    )

    @Test
    fun removeNthFromEnd() {
        val tests =
            listOf(
                RemoveNthNodeFromEndOfListTestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4, 5)),
                    2,
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 5)),
                ),
                RemoveNthNodeFromEndOfListTestData(
                    listNodeUtil.generateListNodeFromList(listOf(1)),
                    1,
                    listNodeUtil.generateListNodeFromList(listOf()),
                ),
                RemoveNthNodeFromEndOfListTestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2)),
                    1,
                    listNodeUtil.generateListNodeFromList(listOf(1)),
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
