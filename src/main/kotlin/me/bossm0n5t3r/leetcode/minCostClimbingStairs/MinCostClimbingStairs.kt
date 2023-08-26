package me.bossm0n5t3r.leetcode.minCostClimbingStairs

class MinCostClimbingStairs {
    class Solution {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val topIndex = cost.size
            val dp = IntArray(topIndex + 1)
            for (i in 0..topIndex) {
                when (i) {
                    0, 1 -> dp[i] = cost[i]
                    topIndex -> dp[i] = minOf(dp[i - 1], dp[i - 2])
                    else -> dp[i] = cost[i] + minOf(dp[i - 1], dp[i - 2])
                }
            }
            return dp[topIndex]
        }
    }
}
