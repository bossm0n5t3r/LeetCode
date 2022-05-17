package distributeCoinsInBinaryTree

import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

internal class DistributeCoinsInBinaryTreeTest {
    private val distributeCoinsInBinaryTree = DistributeCoinsInBinaryTree()
    private val treeNodeUtil = TreeNodeUtil()

    private data class DistributeCoinsInBinaryTreeTestData(
        val root: TreeNode?,
        val result: Int
    )

    @Test
    fun distributeCoins() {
        val tests = listOf(
            DistributeCoinsInBinaryTreeTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(3, 0, 0)),
                2
            ),
            DistributeCoinsInBinaryTreeTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(0, 3, 0)),
                3
            ),
        )
        tests.forEach { test ->
            distributeCoinsInBinaryTree.distributeCoins(test.root)
                .also {
                    assertEquals(it, test.result)
                }
        }
    }
}
