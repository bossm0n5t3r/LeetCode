package kthSmallestElementInABST

import utils.TreeNode

class KthSmallestElementInABST {
    companion object {
        var count = 0
        var number = 0
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1
        count = k
        dfs(root)
        return number
    }

    private fun dfs(cur: TreeNode) {
        if (cur.left != null) dfs(cur.left!!)
        count--
        if (count == 0) {
            number = cur.`val`
            return
        }
        if (cur.right != null) dfs(cur.right!!)
    }
}
