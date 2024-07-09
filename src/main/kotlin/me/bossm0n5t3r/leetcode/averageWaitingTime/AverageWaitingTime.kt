package me.bossm0n5t3r.leetcode.averageWaitingTime

class AverageWaitingTime {
    class Solution {
        fun averageWaitingTime(customers: Array<IntArray>): Double {
            var currentTime = 0
            var totalWaitTime = 0.0
            for ((arrival, time) in customers) {
                if (currentTime < arrival) {
                    currentTime = arrival
                }
                currentTime += time
                totalWaitTime += currentTime - arrival
            }
            return totalWaitTime / customers.size
        }
    }
}
