package me.bossm0n5t3r.leetcode.symmetricTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SymmetricTreeTest {
    private val symmetricTree = SymmetricTree.Solution()
    private val treeNodeUtil = TreeNodeUtil()

    data class SymmetricTreeTestData(
        val root: TreeNode?,
        val result: Boolean,
    )

    @Test
    fun isSymmetric() {
        val tests = listOf(
            SymmetricTreeTestData(treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 2, 3, 4, 4, 3)), true),
            SymmetricTreeTestData(treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 2, null, 3, null, 3)), false),
        )
        tests.forEach { test ->
            assertEquals(symmetricTree.isSymmetric(test.root), test.result)
        }
    }
}
