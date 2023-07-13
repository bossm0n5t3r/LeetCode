package me.bossm0n5t3r.leetcode.findPivotIndex

class FindPivotIndex {
    class Solution {
        fun pivotIndex(nums: IntArray): Int {
            if (nums.size == 1) return 0
            var left = 0
            var right = 0
            for (i in 1 until nums.size) {
                right += nums[i]
            }
            var idx = 0
            while (left != right && idx + 1 < nums.size) {
                left += nums[idx++]
                right -= nums[idx]
            }
            return if (left == right) idx else -1
        }
    }
}
