package me.bossm0n5t3r.leetcode.dominoAndTrominoTiling

import java.math.BigInteger

class DominoAndTrominoTiling {
    class Solution {
        fun numTilings(n: Int): Int {
            if (n == 1) return 1
            if (n == 2) return 2

            val modulo = BigInteger.valueOf(1_000_000_007)
            val dp =
                Array<BigInteger>(n + 1) { BigInteger.ZERO }
                    .also {
                        it[0] = BigInteger.ONE
                        it[1] = BigInteger.ONE
                        it[2] = BigInteger.valueOf(2)
                    }
            for (i in 3..n) {
                dp[i] = dp[i - 1].times(BigInteger.valueOf(2)).plus(dp[i - 3])
            }

            return dp[n].mod(modulo).toInt()
        }
    }
}
