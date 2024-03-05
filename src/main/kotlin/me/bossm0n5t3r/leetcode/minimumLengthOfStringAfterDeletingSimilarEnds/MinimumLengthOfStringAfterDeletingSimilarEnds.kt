package me.bossm0n5t3r.leetcode.minimumLengthOfStringAfterDeletingSimilarEnds

class MinimumLengthOfStringAfterDeletingSimilarEnds {
    class Solution {
        fun minimumLength(s: String): Int {
            var (start, end) = 0 to s.lastIndex
            while (start < end) {
                if (s[start] != s[end]) {
                    break
                }
                val startChar = s[start]
                val endChar = s[end]
                while (start + 1 < end && s[start + 1] == startChar) start++
                while (start < end - 1 && s[end - 1] == endChar) end--
                start++
                end--
            }
            return end - start + 1
        }
    }
}
