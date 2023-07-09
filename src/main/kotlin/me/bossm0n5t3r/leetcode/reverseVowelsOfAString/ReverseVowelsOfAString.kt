package me.bossm0n5t3r.leetcode.reverseVowelsOfAString

class ReverseVowelsOfAString {
    class Solution {
        fun reverseVowels(s: String): String {
            val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            var (start, end) = 0 to s.length - 1
            val split = s.toCharArray()
            while (start < end) {
                while (start < s.length && vowels.contains(s[start]).not()) {
                    start++
                }
                while (end > 0 && vowels.contains(s[end]).not()) {
                    end--
                }
                if (start > end) break
                if (end == 0) break
                val tmp = split[start]
                split[start] = split[end]
                split[end] = tmp

                start++
                end--
            }
            return split.joinToString("")
        }
    }
}
