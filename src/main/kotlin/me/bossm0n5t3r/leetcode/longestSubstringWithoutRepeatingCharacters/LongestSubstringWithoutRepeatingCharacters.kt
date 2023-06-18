package me.bossm0n5t3r.leetcode.longestSubstringWithoutRepeatingCharacters

class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {
            if (s.isEmpty()) return 0
            val cache = mutableMapOf<Char, Int>()
            var result = -1
            var j = 0
            (s.indices).forEach { i ->
                if (cache.containsKey(s[i])) {
                    j = j.coerceAtLeast(cache[s[i]]!! + 1)
                }
                cache[s[i]] = i
                result = result.coerceAtLeast(i - j + 1)
            }
            return result
        }
    }
}
