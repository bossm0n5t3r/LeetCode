package utils

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TreeNodeUtil {
    fun generateTreeNodeOrNull(data: List<Int?>): TreeNode? {
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
}
