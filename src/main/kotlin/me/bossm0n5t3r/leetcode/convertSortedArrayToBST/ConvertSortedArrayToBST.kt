package me.bossm0n5t3r.leetcode.convertSortedArrayToBST

import me.bossm0n5t3r.leetcode.utils.TreeNode

class ConvertSortedArrayToBST {
    class Solution {
        fun sortedArrayToBST(nums: IntArray): TreeNode {
            val resultTreeNode = TreeNode(0)
            insertNumIntoTreeNode(nums, resultTreeNode, 0, nums.size - 1)
            return resultTreeNode
        }

        private fun insertNumIntoTreeNode(
            nums: IntArray,
            treeNode: TreeNode?,
            start: Int,
            end: Int,
        ) {
            if (start == end) {
                treeNode?.`val` = nums[start]
                return
            }
            if (start + 1 == end) {
                treeNode?.`val` = nums[end]
                treeNode?.left = TreeNode(nums[start])
                treeNode?.right = null
                return
            }
            if (start + 2 == end) {
                treeNode?.`val` = nums[(start + end) / 2]
                treeNode?.left = TreeNode(nums[start])
                treeNode?.right = TreeNode(nums[end])
                return
            }
            val mid = (start + end) / 2
            treeNode?.`val` = nums[mid]
            treeNode?.left = TreeNode(0)
            treeNode?.right = TreeNode(0)
            insertNumIntoTreeNode(nums, treeNode?.left, start, mid - 1)
            insertNumIntoTreeNode(nums, treeNode?.right, mid + 1, end)
        }
    }
}
