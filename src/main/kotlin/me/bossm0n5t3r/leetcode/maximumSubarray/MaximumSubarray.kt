package me.bossm0n5t3r.leetcode.maximumSubarray

class MaximumSubarray {
    class Solution {
        fun maxSubArray(nums: IntArray): Int {
            var globalMax = Int.MIN_VALUE
            var localMax = 0
            nums.forEach {
                localMax = if (it + localMax >= it) it + localMax else it
                if (localMax > globalMax) {
                    globalMax = localMax
                }
            }
            return globalMax
        }
    }
}
