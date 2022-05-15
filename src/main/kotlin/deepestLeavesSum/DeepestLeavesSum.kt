package deepestLeavesSum

import utils.TreeNode
import java.util.LinkedList

class DeepestLeavesSum {
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            var curLeavesSum = 0
            val size = queue.size
            var isQueued = false
            repeat(size) {
                val cur = queue.poll()
                curLeavesSum += cur.`val`
                if (!isQueued && (cur.left != null || cur.right != null)) {
                    isQueued = true
                }
                if (cur.left != null) queue.add(cur.left!!)
                if (cur.right != null) queue.add(cur.right!!)
            }
            if (!isQueued) {
                return curLeavesSum
            }
        }
        return -1
    }
}
