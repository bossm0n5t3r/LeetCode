package me.bossm0n5t3r.leetcode.determineIfTwoStringsAreClose

class DetermineIfTwoStringsAreClose {
    class Solution {
        fun closeStrings(word1: String, word2: String): Boolean {
            val word1Map = getCharToCount(word1)
            val word2Map = getCharToCount(word2)

            return (word1Map.keys == word2Map.keys && word1Map.values.sorted() == word2Map.values.sorted())
        }

        private fun getCharToCount(word: String): MutableMap<Char, Int> {
            val result = mutableMapOf<Char, Int>()
            for (c in word) {
                result[c] = result.getOrDefault(c, 0) + 1
            }
            return result
        }
    }
}
