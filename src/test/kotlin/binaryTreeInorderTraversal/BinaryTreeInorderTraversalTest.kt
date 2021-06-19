package binaryTreeInorderTraversal

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

class BinaryTreeInorderTraversalTest {
    private val binaryTreeInorderTraversal = BinaryTreeInorderTraversal()
    private val treeNodeUtil = TreeNodeUtil()

    data class BinaryTreeInorderTraversalTestData(
        val root: TreeNode?,
        val result: List<Int>
    )

    @Test
    fun inorderTraversal() {
        val tests = listOf(
            BinaryTreeInorderTraversalTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2, 3)),
                listOf(1, 3, 2)
            ),
            BinaryTreeInorderTraversalTestData(treeNodeUtil.generateTreeNodeOrNull(listOf()), listOf()),
            BinaryTreeInorderTraversalTestData(treeNodeUtil.generateTreeNodeOrNull(listOf(1)), listOf(1)),
        )
        tests.forEach { test ->
            val result = binaryTreeInorderTraversal.inorderTraversalRecursiveApproach(test.root)
            assertTrue(result.containsAll(test.result))
            assertEquals(result.size, test.result.size)
        }
    }
}
