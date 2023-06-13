package me.bossm0n5t3r.leetcode.binaryTreeLevelOrderTraversal

import me.bossm0n5t3r.leetcode.utils.TreeNode
import java.util.LinkedList

class BinaryTreeLevelOrderTraversal {
    class Solution {
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
}
