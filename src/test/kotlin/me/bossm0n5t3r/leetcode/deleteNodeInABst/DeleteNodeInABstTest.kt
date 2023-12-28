package me.bossm0n5t3r.leetcode.deleteNodeInABst

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class DeleteNodeInABstTest {
    private val sut = DeleteNodeInABst.Solution()
    private val treeNodeUtil = TreeNodeUtil()

    private data class TestData(
        val root: TreeNode?,
        val key: Int,
        val result: TreeNode?,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 3,
                    result = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 4, 6, 2, null, null, 7)),
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 0,
                    result = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf()),
                    key = 0,
                    result = treeNodeUtil.generateTreeNodeOrNull(listOf()),
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(0)),
                    key = 0,
                    result = treeNodeUtil.generateTreeNodeOrNull(listOf()),
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 5,
                    result = treeNodeUtil.generateTreeNodeOrNull(listOf(6, 3, 7, 2, 4)),
                ),
                TestData(
                    root = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, 7)),
                    key = 7,
                    result = treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4)),
                ),
            )

        tests.forEach { test ->
            assertTrue {
                treeNodeUtil.isEqual(
                    sut.deleteNode(test.root, test.key)
                        .also { treeNodeUtil.printTreeNode(it) },
                    test.result,
                )
            }
        }
    }
}
