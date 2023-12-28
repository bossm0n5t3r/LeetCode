package me.bossm0n5t3r.leetcode.dominoAndTrominoTiling

import java.math.BigInteger

class DominoAndTrominoTiling {
    class Solution {
        fun numTilings(n: Int): Int {
            if (n == 1) return 1
            if (n == 2) return 2
            if (n == 3) return 5

            val module =
                BigInteger.valueOf(10L)
                    .pow(9)
                    .plus(BigInteger.valueOf(7L))
            val dp =
                LongArray(n + 1).apply {
                    this[1] = 1
                    this[2] = 2
                    this[3] = 2 + 3
                }
            for (i in 4..n) {
                dp[i] = dp[i - 1] + (dp[i - 2] * 3) + (dp[i - 3] * 2)
            }
            return dp[n].toBigInteger().mod(module).toInt()
        }
    }
}
