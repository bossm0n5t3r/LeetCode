package me.bossm0n5t3r.leetcode.distributeCoinsInBinaryTree

import me.bossm0n5t3r.leetcode.utils.TreeNode
import kotlin.math.abs

class DistributeCoinsInBinaryTree {
    class Solution {
        fun distributeCoins(root: TreeNode?): Int {
            val result = IntWrapper()
            dfs(root, result)
            return result.value
        }

        private data class IntWrapper(var value: Int = 0)

        private fun dfs(node: TreeNode?, intWrapper: IntWrapper): Int {
            if (node == null) return 0
            val L = dfs(node.left, intWrapper)
            val R = dfs(node.right, intWrapper)
            intWrapper.value += abs(L) + abs(R)
            return node.`val` + L + R - 1
        }
    }
}
