package me.bossm0n5t3r.leetcode.sameTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SameTreeTest {
    private val sut = SameTree.Solution()
    private val treeNodeUtil = TreeNodeUtil()

    private data class TestData(
        val p: TreeNode?,
        val q: TreeNode?,
        val result: Boolean,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3)),
                    treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3)),
                    true,
                ),
                TestData(
                    treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2)),
                    treeNodeUtil.generateTreeNodeOrNull(listOf(1, null, 2)),
                    false,
                ),
                TestData(
                    treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 1)),
                    treeNodeUtil.generateTreeNodeOrNull(listOf(1, 1, 2)),
                    false,
                ),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.isSameTree(test.p, test.q),
            )
        }
    }
}
