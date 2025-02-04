package me.bossm0n5t3r.leetcode.maximumascendingsubarraysum

class MaximumAscendingSubarraySum {
    class Solution {
        fun maxAscendingSum(nums: IntArray): Int {
            var result = 0
            for (i in nums.indices) {
                result = maxOf(result, findMaxAscendingSum(nums, i))
            }
            return result
        }

        private fun findMaxAscendingSum(
            nums: IntArray,
            index: Int,
        ): Int {
            var result = 0
            var prev = 0
            for (i in index until nums.size) {
                if (nums[i] <= prev) return result
                prev = nums[i]
                result += prev
            }
            return result
        }
    }
}
