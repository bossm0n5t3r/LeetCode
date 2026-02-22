package me.bossm0n5t3r.leetcode.countbinarysubstrings

class CountBinarySubstrings {
    class Solution {
        fun countBinarySubstrings(s: String): Int {
            var result = 0
            var prevCount = 0
            var currCount = 1

            for (i in 1 until s.length) {
                if (s[i] == s[i - 1]) {
                    currCount++
                    continue
                }
                result += minOf(prevCount, currCount)
                prevCount = currCount
                currCount = 1
            }

            result += minOf(prevCount, currCount)

            return result
        }
    }
}
