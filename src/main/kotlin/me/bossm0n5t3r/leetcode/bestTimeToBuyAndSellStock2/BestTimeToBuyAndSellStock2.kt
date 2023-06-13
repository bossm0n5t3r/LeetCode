package me.bossm0n5t3r.leetcode.bestTimeToBuyAndSellStock2

class BestTimeToBuyAndSellStock2 {
    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var result = 0
            for (i in 0 until prices.size - 1) {
                val diff = prices[i + 1] - prices[i]
                if (diff > 0) result += diff
            }
            return result
        }
    }
}
