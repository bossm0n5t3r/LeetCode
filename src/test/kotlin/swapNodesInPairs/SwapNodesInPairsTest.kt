package swapNodesInPairs

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertTrue

internal class SwapNodesInPairsTest {
    private val swapNodesInPairs = SwapNodesInPairs()
    private val listNodeUtil = ListNodeUtil()

    private data class SwapNodesInPairsTestData(
        val head: ListNode?,
        val result: ListNode?
    )

    @Test
    fun swapPairs() {
        val tests = listOf(
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
