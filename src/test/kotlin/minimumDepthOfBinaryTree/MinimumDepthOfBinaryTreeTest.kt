package minimumDepthOfBinaryTree

import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

internal class MinimumDepthOfBinaryTreeTest {
    private val minimumDepthOfBinaryTree = MinimumDepthOfBinaryTree()
    private val treeNodeUtil = TreeNodeUtil()

    private data class MinimumDepthOfBinaryTreeTestData(
        val root: TreeNode?,
        val result: Int,
    )

    @Test
    fun minDepth() {
        val tests = listOf(
            MinimumDepthOfBinaryTreeTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                2,
            ),
            MinimumDepthOfBinaryTreeTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(2, null, 3, null, 4, null, 5, null, 6)),
                5,
            ),
        )
        tests.forEach { test ->
            minimumDepthOfBinaryTree.minDepth(test.root)
                .also {
                    println(it)
                    assertEquals(it, test.result)
                }
        }
    }
}
