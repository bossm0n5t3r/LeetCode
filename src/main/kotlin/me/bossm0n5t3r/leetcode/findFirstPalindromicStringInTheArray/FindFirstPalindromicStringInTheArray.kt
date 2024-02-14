package me.bossm0n5t3r.leetcode.findFirstPalindromicStringInTheArray

class FindFirstPalindromicStringInTheArray {
    class Solution {
        fun firstPalindrome(words: Array<String>): String {
            for (word in words) {
                if (isPalindrome(word)) {
                    return word
                }
            }
            return ""
        }

        private fun isPalindrome(word: String): Boolean {
            return word == word.reversed()
        }
    }
}
