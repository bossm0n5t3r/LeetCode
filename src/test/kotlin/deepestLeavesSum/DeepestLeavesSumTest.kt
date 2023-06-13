package deepestLeavesSum

import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

internal class DeepestLeavesSumTest {
    private val deepestLeavesSum = DeepestLeavesSum()
    private val treeNodeUtil = TreeNodeUtil()

    private data class DeepestLeavesSumTestData(
        val root: TreeNode?,
        val result: Int,
    )

    @Test
    fun deepestLeavesSum() {
        val tests = listOf(
            DeepestLeavesSumTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8)),
                15,
            ),
            DeepestLeavesSumTestData(
                treeNodeUtil.generateTreeNodeOrNull(listOf(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)),
                19,
            ),
        )
        tests.forEach { test ->
            deepestLeavesSum.deepestLeavesSum(test.root).also {
                println(it)
                assertEquals(it, test.result)
            }
        }
    }
}
