package me.bossm0n5t3r.leetcode.moveZeroes

class MoveZeroes {
    class Solution {
        fun moveZeroes(nums: IntArray) {
            var lastNonZeroIndex = 0
            for (i in nums.indices) {
                if (nums[i] != 0) {
                    nums[lastNonZeroIndex++] = nums[i]
                }
            }
            for (i in lastNonZeroIndex until nums.size) {
                nums[i] = 0
            }
        }
    }
}
