package me.bossm0n5t3r.leetcode.bestTimeToBuyAndSellStock

class BestTimeToBuyAndSellStock {
    class Solution {
        fun maxProfit(prices: IntArray): Int {
            val diff = IntArray(prices.size - 1)
            for (i in 0 until prices.size - 1) {
                diff[i] = prices[i + 1] - prices[i]
            }
            var globalMax = 0
            var localMax = 0
            diff.forEach {
                localMax = if (it + localMax >= it) it + localMax else it
                if (localMax > globalMax) {
                    globalMax = localMax
                }
            }
            return globalMax
        }
    }
}
