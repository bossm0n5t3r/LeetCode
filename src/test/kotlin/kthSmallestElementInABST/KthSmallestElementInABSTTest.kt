package kthSmallestElementInABST

import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

class KthSmallestElementInABSTTest {
    private val kthSmallestElementInABST = KthSmallestElementInABST()
    private val treeNodeUtil = TreeNodeUtil()

    data class KthSmallestElementInABSTTestData(
        val root: TreeNode?,
        val k: Int,
        val result: Int
    )

    @Test
    fun kthSmallest() {
        val tests = listOf(
            KthSmallestElementInABSTTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(3, 1, 4, null, 2)),
                1,
                1
            ),
            KthSmallestElementInABSTTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, null, 1)),
                3,
                3
            )
        )
        tests.forEach { test ->
            assertEquals(kthSmallestElementInABST.kthSmallest(test.root, test.k), test.result)
        }
    }
}
