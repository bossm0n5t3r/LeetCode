package me.bossm0n5t3r.leetcode.swapNodesInPairs

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class SwapNodesInPairsTest {
    private val swapNodesInPairs = SwapNodesInPairs.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class SwapNodesInPairsTestData(
        val head: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun swapPairs() {
        val tests =
            listOf(
                SwapNodesInPairsTestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4)),
                    listNodeUtil.generateListNodeFromList(listOf(2, 1, 4, 3)),
                ),
                SwapNodesInPairsTestData(
                    listNodeUtil.generateListNodeFromList(listOf()),
                    listNodeUtil.generateListNodeFromList(listOf()),
                ),
                SwapNodesInPairsTestData(
                    listNodeUtil.generateListNodeFromList(listOf(1)),
                    listNodeUtil.generateListNodeFromList(listOf(1)),
                ),
                SwapNodesInPairsTestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3)),
                    listNodeUtil.generateListNodeFromList(listOf(2, 1, 3)),
                ),
            )
        tests.forEach { test ->
            val result = swapNodesInPairs.swapPairs(test.head)
            listNodeUtil.printListNode(result)
            assertTrue(listNodeUtil.isEqual(result, test.result))
        }
    }
}
