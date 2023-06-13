package symmetricTree

import org.junit.jupiter.api.Test
import utils.TreeNode
import utils.TreeNodeUtil
import kotlin.test.assertEquals

class SymmetricTreeTest {
    private val symmetricTree = SymmetricTree()
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
