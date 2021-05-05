package maximumDepthOfBinaryTree

import java.util.LinkedList
import java.util.Queue

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        var height = 0
        var cur: TreeNode
        var size: Int
        while (q.isNotEmpty()) {
            height++
            size = q.size
            for (i in 0 until size) {
                cur = q.poll()
                if (cur.left != null) {
                    q.add(cur.left)
                }
                if (cur.right != null) {
                    q.add(cur.right)
                }
            }
        }
        return height
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
