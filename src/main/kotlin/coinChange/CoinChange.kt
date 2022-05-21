package coinChange

import kotlin.math.min

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val dp = IntArray(amount + 1) { -1 }
        coins.forEach { if (it <= amount) { dp[it] = 1 } }
        (1..amount).forEach {
            for (coin in coins) {
                if (it - coin > 0 && dp[it - coin] > 0) {
                    dp[it] = if (dp[it] == -1) {
                        dp[it - coin] + 1
                    } else {
                        min(dp[it], dp[it - coin] + 1)
                    }
                }
            }
        }
        println(dp.toList())
        return dp[amount]
    }
}
