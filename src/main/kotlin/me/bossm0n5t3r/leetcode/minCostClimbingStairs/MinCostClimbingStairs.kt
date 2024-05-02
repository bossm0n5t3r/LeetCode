package me.bossm0n5t3r.leetcode.minCostClimbingStairs

class MinCostClimbingStairs {
    class Solution {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val topIndex = cost.size
            val dp = IntArray(topIndex + 1)
            for (i in 2..topIndex) {
                dp[i] = minOf(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1])
            }
            return dp[topIndex]
        }
    }
}
