package me.bossm0n5t3r.leetcode.uniquePaths2

class UniquePaths2 {
    class Solution {
        fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
            val m = obstacleGrid.size
            val n = obstacleGrid.first().size
            val dp = Array(m + 1) { IntArray(n + 1) }
            dp[0][1] = 1
            (1..m).forEach { r ->
                (1..n).forEach { c ->
                    if (obstacleGrid[r - 1][c - 1] == 0) {
                        dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
                    }
                }
            }
            return dp[m][n]
        }
    }
}
