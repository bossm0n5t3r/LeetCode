package me.bossm0n5t3r.leetcode.uniquelength3palindromicsubsequences

class UniqueLength3PalindromicSubsequences {
    class Solution {
        fun countPalindromicSubsequence(s: String): Int {
            val firstIndex = IntArray(26) { -1 }
            val lastIndex = IntArray(26) { -1 }
            for (i in s.indices) {
                val c = s[i] - 'a'
                if (firstIndex[c] == -1) {
                    firstIndex[c] = i
                }
                lastIndex[c] = i
            }
            var result = 0
            for (c in 0 until 26) {
                if (firstIndex[c] != -1) {
                    val set = mutableSetOf<Char>()
                    for (i in firstIndex[c] + 1 until lastIndex[c]) {
                        set.add(s[i])
                    }
                    result += set.size
                }
            }
            return result
        }
    }
}
