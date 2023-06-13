package maximumDepthOfBinaryTree

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil

class MaximumDepthOfBinaryTreeTest {
    private val maximumDepthOfBinaryTree = MaximumDepthOfBinaryTree()
    private val treeNodeUtil = TreeNodeUtil()

    data class MaximumDepthOfBinaryTreeTestData(
        val root: TreeNode?,
        val result: Int,
    )

    @Test
    fun maxDepth() {
        val tests = listOf(
            MaximumDepthOfBinaryTreeTestData(
                root = treeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                result = 3,
            ),
            MaximumDepthOfBinaryTreeTestData(
                root = treeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2)),
                result = 2,
            ),
            MaximumDepthOfBinaryTreeTestData(
                root = treeNodeUtil.generateTreeNodeOrNull(listOf()),
                result = 0,
            ),
            MaximumDepthOfBinaryTreeTestData(
                root = treeNodeUtil.generateTreeNodeOrNull(listOf(0)),
                result = 1,
            ),
        )
        tests.forEach { test ->
            assertTrue(maximumDepthOfBinaryTree.maxDepth(test.root) == test.result)
        }
    }
}
