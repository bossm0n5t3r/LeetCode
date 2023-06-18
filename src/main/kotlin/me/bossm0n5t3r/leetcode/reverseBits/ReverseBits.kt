package me.bossm0n5t3r.leetcode.reverseBits

class ReverseBits {
    class Solution {
        // you need treat n as an unsigned value
        fun reverseBits(n: Int): Int {
            var target = if (n >= 0) n else -n - 1
            var sum = 0
            var power = 31
            while (target > 0) {
                sum += (target % 2) shl power
                power--
                target /= 2
            }
            return if (n < 0) {
                -(sum + 1)
            } else {
                sum
            }
        }
    }
}
