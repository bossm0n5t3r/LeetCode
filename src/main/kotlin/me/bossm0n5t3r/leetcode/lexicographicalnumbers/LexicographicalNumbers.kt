package me.bossm0n5t3r.leetcode.lexicographicalnumbers

class LexicographicalNumbers {
    class Solution {
        fun lexicalOrder(n: Int): List<Int> {
            val result = mutableListOf<Int>()
            var value = 1
            var countN = n
            while (countN-- > 0) {
                result.add(value)
                if (value * 10 <= n) {
                    value *= 10
                    continue
                }
                while (value % 10 == 9 || value == n) {
                    value /= 10
                }
                value += 1
            }
            return result
        }
    }
}
