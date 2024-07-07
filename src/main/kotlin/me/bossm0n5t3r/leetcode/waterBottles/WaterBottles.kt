package me.bossm0n5t3r.leetcode.waterBottles

class WaterBottles {
    class Solution {
        fun numWaterBottles(
            numBottles: Int,
            numExchange: Int,
        ): Int {
            var drinkBottles = 0
            var currentBottles = numBottles
            var emptyBottles = 0
            while (currentBottles > 0) {
                drinkBottles += currentBottles
                emptyBottles += currentBottles
                if (emptyBottles >= numExchange) {
                    currentBottles = emptyBottles / numExchange
                    emptyBottles %= numExchange
                    continue
                }
                break
            }
            return drinkBottles
        }
    }
}
