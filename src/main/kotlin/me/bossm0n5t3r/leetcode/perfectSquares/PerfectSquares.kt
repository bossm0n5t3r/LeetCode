package me.bossm0n5t3r.leetcode.perfectSquares

class PerfectSquares {
    class Solution {
        fun numSquares(n: Int): Int {
            val dp = IntArray(n + 1) { 0 }
            for (i in 1..n) {
                dp[i] = i
                var j = 1
                while (j * j <= i) {
                    dp[i] = minOf(dp[i], dp[i - j * j] + 1)
                    j++
                }
            }
            return dp[n]
        }
    }
}
