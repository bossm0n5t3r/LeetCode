package me.bossm0n5t3r.leetcode.maximumascendingsubarraysum

class MaximumAscendingSubarraySum {
    class Solution {
        fun maxAscendingSum(nums: IntArray): Int {
            var result = 0
            var sum = 0
            for (i in nums.indices) {
                sum += nums[i]
                if (i == nums.size - 1 || nums[i] >= nums[i + 1]) {
                    result = maxOf(result, sum)
                    sum = 0
                }
            }
            return result
        }
    }
}
