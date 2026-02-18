package me.bossm0n5t3r.leetcode.binarynumberwithalternatingbits

class BinaryNumberWithAlternatingBits {
    class Solution {
        fun hasAlternatingBits(n: Int): Boolean {
            var tmp = n
            while (tmp != 0) {
                if ((tmp and 1) == ((tmp shr 1) and 1)) {
                    return false
                }
                tmp = tmp shr 1
            }
            return true
        }
    }
}
