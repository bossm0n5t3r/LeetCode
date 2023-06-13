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
        val result: List<Int>,
    )

    @Test
    fun inorderTraversal() {
        val tests = listOf(
            BinaryTreeInorderTraversalTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2, 3)),
                listOf(1, 3, 2),
            ),
            BinaryTreeInorderTraversalTestData(treeNodeUtil.generateTreeNodeOrNull(listOf()), listOf()),
            BinaryTreeInorderTraversalTestData(treeNodeUtil.generateTreeNodeOrNull(listOf(1)), listOf(1)),
        )
        tests.forEach { test ->
            // RecursiveApproach
            val resultRecursiveApproach = binaryTreeInorderTraversal.inorderTraversalRecursiveApproach(test.root)
            assertTrue(resultRecursiveApproach.containsAll(test.result))
            assertEquals(resultRecursiveApproach.size, test.result.size)

            // Iterating Method Using Stack
            val resultIteratingMethodUsingStack =
                binaryTreeInorderTraversal.inorderTraversalIteratingMethodUsingStack(test.root)
            assertTrue(resultIteratingMethodUsingStack.containsAll(test.result))
            assertEquals(resultIteratingMethodUsingStack.size, test.result.size)

            // Morris Traversal
            val resultMorrisTraversal = binaryTreeInorderTraversal.inorderTraversalMorrisTraversal(test.root)
            assertTrue(resultMorrisTraversal.containsAll(test.result))
            assertEquals(resultMorrisTraversal.size, test.result.size)
        }
    }
}
