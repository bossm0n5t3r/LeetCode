package me.bossm0n5t3r.leetcode.applyoperationstoanarray

class ApplyOperationsToAnArray {
    class Solution {
        fun applyOperations(nums: IntArray): IntArray {
            for (i in 0 until nums.size - 1) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2
                    nums[i + 1] = 0
                }
            }
            val result = IntArray(nums.size) { 0 }
            var index = 0
            for (i in nums.indices) {
                if (nums[i] != 0) {
                    result[index++] = nums[i]
                }
            }
            return result
        }
    }
}
