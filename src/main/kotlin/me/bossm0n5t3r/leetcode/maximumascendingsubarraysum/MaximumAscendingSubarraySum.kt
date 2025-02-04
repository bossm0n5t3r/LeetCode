package me.bossm0n5t3r.leetcode.maximumascendingsubarraysum

class MaximumAscendingSubarraySum {
    class Solution {
        fun maxAscendingSum(nums: IntArray): Int {
            var result = nums[0]
            var currentSum = nums[0]
            for (i in 1 until nums.size) {
                if (nums[i] > nums[i - 1]) {
                    currentSum += nums[i]
                } else {
                    currentSum = nums[i]
                }
                result = maxOf(result, currentSum)
            }
            return result
        }
    }
}
