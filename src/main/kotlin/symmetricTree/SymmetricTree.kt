package symmetricTree

import utils.TreeNode
import java.util.LinkedList
import java.util.Queue

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        val q: Queue<TreeNode?> = LinkedList()
        q.add(root)
        while (q.isNotEmpty()) {
            val qList = mutableListOf<Int?>()
            val qSize = q.size
            for (i in 0 until qSize) {
                val cur = q.poll()
                qList.add(cur?.`val`)
                if (cur != null) {
                    q.add(cur.left)
                    q.add(cur.right)
                }
            }
            val length = qList.size
            for (i in 0..(length / 2)) {
                if (qList[i] != qList[length - i - 1]) return false
            }
        }
        return true
    }
}
