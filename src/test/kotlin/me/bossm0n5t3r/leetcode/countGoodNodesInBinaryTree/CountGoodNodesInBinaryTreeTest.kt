package me.bossm0n5t3r.leetcode.countGoodNodesInBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountGoodNodesInBinaryTreeTest {
    private val sut = CountGoodNodesInBinaryTree.Solution()
    private val treeNodeUtil = TreeNodeUtil()

    private data class TestData(
        val root: TreeNode?,
        val result: Int,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(3, 1, 4, 3, null, 1, 5)),
                    result = 4,
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(3, 3, null, 4, 2)),
                    result = 3,
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(1)),
                    result = 1,
                ),
            )

        tests.forEach { test ->
            assertEquals(
                sut.goodNodes(test.root),
                test.result,
            )
        }
    }
}
