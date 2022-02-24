package binaryTreeLevelOrderTraversal

import utils.TreeNode
import java.util.LinkedList

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            result.add(queue.toList().map { it.`val` })
            for (i in queue.indices) {
                val cur = queue.poll()
                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
            }
        }
        return result
    }
}
