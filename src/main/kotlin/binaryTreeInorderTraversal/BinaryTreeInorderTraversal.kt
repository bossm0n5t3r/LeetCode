package binaryTreeInorderTraversal

import utils.TreeNode
import java.util.Stack

class BinaryTreeInorderTraversal {
    fun inorderTraversalRecursiveApproach(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        return inorder(root, result)
    }

    private fun inorder(root: TreeNode?, result: MutableList<Int>): List<Int> {
        if (root != null) {
            inorder(root.left, result)
            result.add(root.`val`)
            inorder(root.right, result)
        }
        return result
    }

    fun inorderTraversalIteratingMethodUsingStack(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur = root
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.pop()
            result.add(cur.`val`)
            cur = cur.right
        }
        return result
    }
}
