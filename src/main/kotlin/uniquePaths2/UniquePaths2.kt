package uniquePaths2

class UniquePaths2 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid.first().size
        val dp = Array(m) { IntArray(n) }
        for (r in 0 until m) {
            if (obstacleGrid[r][0] == 1) break
            dp[r][0] = 1
        }
        for (c in 0 until n) {
            if (obstacleGrid[0][c] == 1) break
            dp[0][c] = 1
        }
        (1 until m).forEach { r ->
            (1 until n).forEach { c ->
                if (obstacleGrid[r][c] == 0) {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
                }
            }
        }
        return dp[m - 1][n - 1]
    }
}
