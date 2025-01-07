package me.bossm0n5t3r.leetcode.stringmatchinginanarray

class StringMatchingInAnArray {
    class Solution {
        fun stringMatching(words: Array<String>): List<String> {
            return words
                .sortedBy { it.length }
                .filter {
                    for (word in words) {
                        if (word.length < it.length) continue
                        if (word != it && word.contains(it)) {
                            return@filter true
                        }
                    }
                    false
                }
        }
    }
}
