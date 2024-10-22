package me.bossm0n5t3r.leetcode.lowestcommonancestorofdeepestleaves

import me.bossm0n5t3r.leetcode.utils.TreeNode
import me.bossm0n5t3r.leetcode.utils.TreeNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LowestCommonAncestorOfDeepestLeavesTest {
    private val sut = LowestCommonAncestorOfDeepestLeaves.Solution()

    private data class TestData(
        val root: TreeNode?,
        val result: TreeNode?,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)),
                    TreeNodeUtil.generateTreeNodeOrNull(listOf(2, 7, 4)),
                ),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(1)), TreeNodeUtil.generateTreeNodeOrNull(listOf(1))),
                TestData(TreeNodeUtil.generateTreeNodeOrNull(listOf(0, 1, 3, null, 2)), TreeNodeUtil.generateTreeNodeOrNull(listOf(2))),
            )

        for (testData in testDataList) {
            assertTrue {
                TreeNodeUtil.isEqual(
                    testData.result,
                    sut.lcaDeepestLeaves(testData.root),
                )
            }
        }
    }
}
