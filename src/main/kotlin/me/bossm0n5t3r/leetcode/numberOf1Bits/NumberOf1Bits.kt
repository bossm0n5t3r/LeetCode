package me.bossm0n5t3r.leetcode.numberOf1Bits

class NumberOf1Bits {
    class Solution {
        // you need treat n as an unsigned value
        fun hammingWeight(n: Int): Int {
            var target = if (n >= 0) n else -n - 1
            var count = 0
            while (target > 0) {
                val remain = target % 2
                if (remain > 0) {
                    count++
                }
                target /= 2
            }
            return if (n >= 0) count else 32 - count
        }
    }
}
