package me.bossm0n5t3r.leetcode.firstUniqueCharacterInAString

class FirstUniqueCharacterInAString {
    class Solution {
        fun firstUniqChar(s: String): Int {
            val result = mutableMapOf<Char, MutableList<Int>>()
            for (i in s.indices) {
                if (result.containsKey(s[i])) {
                    result[s[i]]?.add(i)
                } else {
                    result[s[i]] = mutableListOf(i)
                }
            }
            return result.values.filter { it.size < 2 }.minOfOrNull { it[0] } ?: -1
        }
    }
}
