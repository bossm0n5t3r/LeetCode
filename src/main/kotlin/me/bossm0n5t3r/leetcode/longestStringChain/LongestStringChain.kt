package me.bossm0n5t3r.leetcode.longestStringChain

class LongestStringChain {
    class Solution {
        fun longestStrChain(words: Array<String>): Int {
            val sortedWords = words.sortedBy { it.length }
            val dp = mutableMapOf<String, Int>()
            sortedWords.forEach { word ->
                dp[word] = word.indices.maxOf { i ->
                    val tmp = word.take(i) + word.drop(i + 1)
                    dp.getOrDefault(tmp, 0) + 1
                }
            }
            return dp.values.maxOrNull() ?: -1
        }
    }
}
