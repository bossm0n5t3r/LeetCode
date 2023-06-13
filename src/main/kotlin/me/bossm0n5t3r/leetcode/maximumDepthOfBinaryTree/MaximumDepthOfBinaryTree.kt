package me.bossm0n5t3r.leetcode.maximumDepthOfBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import java.util.LinkedList
import java.util.Queue

class MaximumDepthOfBinaryTree {
    class Solution {
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
}
