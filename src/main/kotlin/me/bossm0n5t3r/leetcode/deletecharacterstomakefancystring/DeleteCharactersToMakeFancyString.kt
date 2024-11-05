package me.bossm0n5t3r.leetcode.deletecharacterstomakefancystring

class DeleteCharactersToMakeFancyString {
    class Solution {
        fun makeFancyString(s: String): String {
            val result = StringBuilder().apply { append(s[0]) }
            var count = 1
            for (i in 1 until s.length) {
                count =
                    if (s[i] == s[i - 1]) {
                        count + 1
                    } else {
                        1
                    }
                if (count < 3) {
                    result.append(s[i])
                }
            }
            return result.toString()
        }
    }
}
