package me.bossm0n5t3r.leetcode.isSubsequence

class IsSubsequence {
    class Solution {
        fun isSubsequence(s: String, t: String): Boolean {
            if (s.isEmpty()) return true
            val sChars = s.toSet()
            val tChars = t.toSet()
            if (tChars.containsAll(sChars).not()) return false

            var sIdx = 0
            for (tChar in t) {
                if (tChar != s[sIdx]) continue
                sIdx++
                if (sIdx == s.length) return true
            }
            return false
        }
    }
}
