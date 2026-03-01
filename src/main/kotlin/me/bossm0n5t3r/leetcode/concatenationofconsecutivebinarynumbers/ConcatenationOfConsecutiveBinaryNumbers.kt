package me.bossm0n5t3r.leetcode.concatenationofconsecutivebinarynumbers

class ConcatenationOfConsecutiveBinaryNumbers {
    class Solution {
        fun concatenatedBinary(n: Int): Int {
            var result = 0L
            val modulo = 1_000_000_007L
            var bits = 0
            for (i in 1..n) {
                if ((i and (i - 1)) == 0) bits++
                result = ((result shl bits) or i.toLong()) % modulo
            }
            return result.toInt()
        }
    }
}
