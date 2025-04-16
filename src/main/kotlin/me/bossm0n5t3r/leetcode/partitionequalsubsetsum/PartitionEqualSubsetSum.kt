package me.bossm0n5t3r.leetcode.partitionequalsubsetsum

class PartitionEqualSubsetSum {
    class Solution {
        fun canPartition(nums: IntArray): Boolean {
            val n = nums.size

            val sum = nums.reduce { acc, i -> acc + i }
            if (sum % 2 != 0) return false
            val half = sum / 2

            val dp = Array(nums.size + 1) { BooleanArray(half + 1) }
            dp[0][0] = true

            for (r in 1..n) {
                for (c in 0..half) {
                    dp[r][c] =
                        if (c - nums[r - 1] >= 0) {
                            dp[r - 1][c - nums[r - 1]] || dp[r - 1][c]
                        } else {
                            dp[r - 1][c]
                        }
                }
            }

            return dp[n][half]
        }
    }
}
