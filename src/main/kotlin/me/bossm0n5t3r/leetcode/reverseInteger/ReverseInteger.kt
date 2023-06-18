package me.bossm0n5t3r.leetcode.reverseInteger

class ReverseInteger {
    class Solution {
        fun reverse(x: Int): Int {
            if (x == 0) return 0
            val originalSign = if (x > 0) 1 else -1
            var target = if (x > 0) x else -x
            var result = 0
            while (target > 0) {
                val remainder = target % 10
                if (result > Int.MAX_VALUE / 10) return 0
                if (result == Int.MAX_VALUE / 10 && remainder > 7) return 0
                result = result * 10 + remainder
                target /= 10
            }
            return result * originalSign
        }
    }
}
