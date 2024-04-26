package me.bossm0n5t3r.leetcode.minimumFallingPathSumTwo

class MinimumFallingPathSumTwo {
    class Solution {
        fun minFallingPathSum(grid: Array<IntArray>): Int {
            val n = grid.size
            val dp = Array(n) { IntArray(n) { 0 } }
            for (r in 0 until n) {
                for (c in 0 until n) {
                    if (r == 0) {
                        dp[r][c] = grid[r][c]
                        continue
                    }
                    var minPreviousDp = Int.MAX_VALUE
                    for (i in 0 until n) {
                        if (i != c && minPreviousDp > dp[r - 1][i]) {
                            minPreviousDp = dp[r - 1][i]
                        }
                    }
                    dp[r][c] = grid[r][c] + minPreviousDp
                }
            }
            return dp[n - 1].min()
        }
    }
}
