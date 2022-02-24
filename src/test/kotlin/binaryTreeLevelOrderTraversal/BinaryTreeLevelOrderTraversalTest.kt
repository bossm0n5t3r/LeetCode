package binaryTreeLevelOrderTraversal

import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

class BinaryTreeLevelOrderTraversalTest {
    private val binaryTreeLevelOrderTraversal = BinaryTreeLevelOrderTraversal()
    private val treeNodeUtil = TreeNodeUtil()

    data class BinaryTreeLevelOrderTraversalTestData(
        val root: TreeNode?,
        val result: List<List<Int>>
    )

    @Test
    fun levelOrder() {
        val tests = listOf(
            BinaryTreeLevelOrderTraversalTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                listOf(listOf(3), listOf(9, 20), listOf(15, 7))
            ),
            BinaryTreeLevelOrderTraversalTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(1)),
                listOf(listOf(1))
            ),
            BinaryTreeLevelOrderTraversalTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf()),
                listOf()
            )
        )
        tests.forEach { test ->
            assertEquals(binaryTreeLevelOrderTraversal.levelOrder(test.root), test.result)
        }
    }
}
