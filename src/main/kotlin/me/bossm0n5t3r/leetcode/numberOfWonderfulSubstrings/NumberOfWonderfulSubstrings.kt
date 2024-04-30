package me.bossm0n5t3r.leetcode.numberOfWonderfulSubstrings

class NumberOfWonderfulSubstrings {
    class Solution {
        fun wonderfulSubstrings(word: String): Long {
            val count = mutableMapOf(0 to 1L)
            var result = 0L
            var bitmask = 0
            for (ch in word) {
                val charIndex = ch.code - 'a'.code
                bitmask = bitmask xor (1 shl charIndex)
                result += count.getOrDefault(bitmask, 0)
                for (i in 0..9) {
                    result += count.getOrDefault(bitmask xor (1 shl i), 0)
                }
                count[bitmask] = count.getOrDefault(bitmask, 0) + 1
            }
            return result
        }
    }
}
