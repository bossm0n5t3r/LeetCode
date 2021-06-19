package binaryTreeInorderTraversal

import utils.TreeNode

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
}
