package me.bossm0n5t3r.leetcode.kthSmallestElementInABST

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KthSmallestElementInABSTTest {
    private val kthSmallestElementInABST = KthSmallestElementInABST.Solution()
    private val treeNodeUtil = TreeNodeUtil()

    data class KthSmallestElementInABSTTestData(
        val root: TreeNode?,
        val k: Int,
        val result: Int,
    )

    @Test
    fun kthSmallest() {
        val tests =
            listOf(
                KthSmallestElementInABSTTestData(
                    treeNodeUtil.generateTreeNodeOrNull(listOf(3, 1, 4, null, 2)),
                    1,
                    1,
                ),
                KthSmallestElementInABSTTestData(
                    treeNodeUtil.generateTreeNodeOrNull(listOf(5, 3, 6, 2, 4, null, null, 1)),
                    3,
                    3,
                ),
            )
        tests.forEach { test ->
            assertEquals(kthSmallestElementInABST.kthSmallest(test.root, test.k), test.result)
        }
    }
}
