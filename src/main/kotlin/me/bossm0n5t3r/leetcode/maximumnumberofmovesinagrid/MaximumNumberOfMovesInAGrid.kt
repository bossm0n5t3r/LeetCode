package me.bossm0n5t3r.leetcode.maximumnumberofmovesinagrid

class MaximumNumberOfMovesInAGrid {
    class Solution {
        fun maxMoves(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid.first().size

            val dp = Array(m) { IntArray(n) }

            var result = 0
            for (c in n - 2 downTo 0) {
                for (r in 0 until m) {
                    val tmp = mutableListOf<Int>()
                    if (grid[r][c] < grid[r][c + 1]) {
                        tmp += dp[r][c + 1]
                    }
                    if (r >= 1 && grid[r][c] < grid[r - 1][c + 1]) {
                        tmp += dp[r - 1][c + 1]
                    }
                    if (r <= m - 2 && grid[r][c] < grid[r + 1][c + 1]) {
                        tmp += dp[r + 1][c + 1]
                    }
                    dp[r][c] = tmp.maxOrNull()?.plus(1) ?: 0
                }
                if (c == 0) {
                    for (r in 0 until m) {
                        result = maxOf(result, dp[r][0])
                    }
                }
            }

            return result
        }
    }
}
