package me.bossm0n5t3r.leetcode.countprefixandsuffixpairsi

class CountPrefixAndSuffixPairsI {
    class Solution {
        fun countPrefixSuffixPairs(words: Array<String>): Int {
            val n = words.size
            var count = 0
            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    if (words[i] isPrefixAndSuffix words[j]) count++
                }
            }
            return count
        }

        private infix fun String.isPrefixAndSuffix(other: String): Boolean =
            this.length <= other.length && other.startsWith(this) && other.endsWith(this)
    }
}
