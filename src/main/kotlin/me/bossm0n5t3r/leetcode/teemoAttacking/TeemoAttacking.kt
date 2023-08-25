package me.bossm0n5t3r.leetcode.teemoAttacking

class TeemoAttacking {
    class Solution {
        fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
            val result = sortedSetOf<Int>()
            for (time in timeSeries) {
                if (result.isEmpty()) {
                    result.addAll(time until time + duration)
                    continue
                }
                if (result.last() <= time + duration - 1) {
                    result.addAll(maxOf(time, result.last()) until time + duration)
                }
            }
            return result.size
        }
    }
}
