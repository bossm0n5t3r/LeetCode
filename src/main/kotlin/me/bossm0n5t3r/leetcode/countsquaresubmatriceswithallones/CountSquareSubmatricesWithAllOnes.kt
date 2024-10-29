package me.bossm0n5t3r.leetcode.countsquaresubmatriceswithallones

class CountSquareSubmatricesWithAllOnes {
    class Solution {
        fun countSquares(matrix: Array<IntArray>): Int {
            val (m, n) = matrix.size to matrix.first().size
            val dp = Array(m) { IntArray(n) }

            var result = 0

            for (r in 0 until m) {
                dp[r][0] = matrix[r][0]
                result += dp[r][0]
            }

            for (c in 1 until n) {
                dp[0][c] = matrix[0][c]
                result += dp[0][c]
            }

            for (r in 1 until m) {
                for (c in 1 until n) {
                    if (matrix[r][c] == 1) {
                        dp[r][c] = 1 + minOf(dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1])
                    }
                    result += dp[r][c]
                }
            }

            return result
        }
    }
}
