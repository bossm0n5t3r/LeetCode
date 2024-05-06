package me.bossm0n5t3r.leetcode.removeNodesFromLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class RemoveNodesFromLinkedListTest {
    private val sut = RemoveNodesFromLinkedList.Solution()
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
                    listNodeUtil.generateListNodeFromList(listOf(5, 2, 13, 3, 8)),
                    listNodeUtil.generateListNodeFromList(listOf(13, 8)),
                ),
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 1, 1, 1)),
                    listNodeUtil.generateListNodeFromList(listOf(1, 1, 1, 1)),
                ),
            )

        tests.forEach { test ->
            assertTrue {
                listNodeUtil.isEqual(
                    test.result,
                    sut.removeNodes(test.head),
                )
            }
        }
    }
}
