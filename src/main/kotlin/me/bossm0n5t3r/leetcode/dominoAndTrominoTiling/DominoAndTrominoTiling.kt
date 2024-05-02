package me.bossm0n5t3r.leetcode.dominoAndTrominoTiling

class DominoAndTrominoTiling {
    class Solution {
        fun numTilings(n: Int): Int {
            if (n == 1) return 1
            if (n == 2) return 2

            val modulo = 1_000_000_007L
            val dp = LongArray(n + 1)
            dp[0] = 1L
            dp[1] = 1L
            dp[2] = 2L
            for (i in 3..n) {
                dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % modulo
            }

            return dp[n].toInt()
        }
    }
}
