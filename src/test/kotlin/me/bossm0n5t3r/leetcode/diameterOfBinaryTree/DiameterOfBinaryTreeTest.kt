package me.bossm0n5t3r.leetcode.diameterOfBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DiameterOfBinaryTreeTest {
    private val sut = DiameterOfBinaryTree.Solution()
    private val treeNodeUtil = TreeNodeUtil()

    private data class TestData(
        val root: TreeNode?,
        val result: Int,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3, 4, 5)), 3),
                TestData(treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2)), 1),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.diameterOfBinaryTree(test.root),
            )
        }
    }
}
