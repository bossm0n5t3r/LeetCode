package uniquePaths

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val min = min(m - 1, n - 1)
        val sum = m + n - 2
        var result = 1L
        for (i in 0 until min) {
            result *= (sum - i)
            result /= (i + 1)
        }
        return result.toInt()
    }

    private fun min(m: Int, n: Int): Int {
        return if (m < n) m else n
    }

    fun uniquePathsUsingDP(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                if (r == 0 || c == 0) {
                    dp[r][c] = 1
                } else {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
                }
            }
        }
        return dp[m - 1][n - 1]
    }
}
