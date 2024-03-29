package me.bossm0n5t3r.leetcode.deleteTheMiddleNodeOfALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class DeleteTheMiddleNodeOfALinkedListTest {
    private val sut = DeleteTheMiddleNodeOfALinkedList.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class TestData(
        val head: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 3, 4, 7, 1, 2, 6)),
                    listNodeUtil.generateListNodeFromList(listOf(1, 3, 4, 1, 2, 6)),
                ),
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4)),
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 4)),
                ),
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(2, 1)),
                    listNodeUtil.generateListNodeFromList(listOf(2)),
                ),
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(1)),
                    listNodeUtil.generateListNodeFromList(listOf()),
                ),
            )

        tests.forEach { test ->
            val result = sut.deleteMiddle(test.head)
            listNodeUtil.printListNode(result)
            listNodeUtil.printListNode(test.result)
            assertTrue {
                listNodeUtil.isEqual(
                    result,
                    test.result,
                )
            }
        }
    }
}
