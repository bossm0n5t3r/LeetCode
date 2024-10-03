package me.bossm0n5t3r.leetcode.reverseonlyletters

class ReverseOnlyLetters {
    class Solution {
        fun reverseOnlyLetters(s: String): String {
            val reversedLetters = s.filter { it.isLetter() }.reversed()
            var reversedLettersIndex = 0
            var result = ""
            for (c in s) {
                result +=
                    if (c.isLetter()) {
                        reversedLetters[reversedLettersIndex++]
                    } else {
                        c
                    }
            }
            return result
        }
    }
}
