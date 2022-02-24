package kthSmallestElementInABST

import utils.TreeNode

class KthSmallestElementInABST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1
        val count = IntWrapper()
        val number = IntWrapper()
        dfs(root, k, count, number)
        return number.value
    }

    data class IntWrapper(
        var value: Int = 0
    ) {
        fun increment() {
            value++
        }
    }

    private fun dfs(cur: TreeNode, k: Int, count: IntWrapper, number: IntWrapper) {
        if (cur.left != null) dfs(cur.left!!, k, count, number)
        count.increment()
        if (count.value == k) {
            number.value = cur.`val`
            return
        }
        if (cur.right != null) dfs(cur.right!!, k, count, number)
    }
}
