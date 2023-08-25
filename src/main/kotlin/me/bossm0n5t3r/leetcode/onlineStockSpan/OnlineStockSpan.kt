package me.bossm0n5t3r.leetcode.onlineStockSpan

class OnlineStockSpan {
    class StockSpanner {
        private val monotonicStack = mutableListOf<Int>()

        fun next(price: Int): Int {
            var span = 1
            var lastIndex = monotonicStack.lastIndex
            while (lastIndex >= 0 && price >= monotonicStack[lastIndex]) {
                lastIndex--
                span++
            }
            monotonicStack.add(price)
            return span
        }
    }
}
