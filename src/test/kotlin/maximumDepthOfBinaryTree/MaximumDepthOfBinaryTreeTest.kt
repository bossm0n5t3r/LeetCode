package maximumDepthOfBinaryTree

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.LinkedList
import java.util.Queue

class MaximumDepthOfBinaryTreeTest {
    private val maximumDepthOfBinaryTree = MaximumDepthOfBinaryTree()

    data class MaximumDepthOfBinaryTreeTestData(
        val root: TreeNode?,
        val result: Int
    )

    private fun generateTreeNodeOrNull(data: List<Int?>): TreeNode? {
        if (data.isEmpty()) return null
        val length = data.size
        var index = 0
        val result = TreeNode(data[index]!!)
        index++
        val q: Queue<TreeNode?> = LinkedList()
        q.add(result)
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val cur = q.poll()
                if (cur != null) {
                    if (index != length) {
                        cur.left = if (data[index] != null) TreeNode(data[index]!!) else null
                        index++
                        q.add(cur.left)
                    }
                    if (index != length) {
                        cur.right = if (data[index] != null) TreeNode(data[index]!!) else null
                        index++
                        q.add(cur.right)
                    }
                }
            }
        }
        return result
    }

    @Test
    fun maxDepth() {
        val tests = listOf(
            MaximumDepthOfBinaryTreeTestData(
                root = generateTreeNodeOrNull(listOf(3, 9, 20, null, null, 15, 7)),
                result = 3
            ),
            MaximumDepthOfBinaryTreeTestData(
                root = generateTreeNodeOrNull(listOf(1, null, 2)),
                result = 2
            ),
            MaximumDepthOfBinaryTreeTestData(
                root = generateTreeNodeOrNull(listOf()),
                result = 0
            ),
            MaximumDepthOfBinaryTreeTestData(
                root = generateTreeNodeOrNull(listOf(0)),
                result = 1
            )
        )
        tests.forEach { test ->
            assertTrue(maximumDepthOfBinaryTree.maxDepth(test.root) == test.result)
        }
    }
}
