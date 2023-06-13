package me.bossm0n5t3r.leetcode.countAndSay

class CountAndSay {
    class Solution {
        fun countAndSay(n: Int): String {
            if (n == 1) return "1"
            val prev = countAndSay(n - 1)
            val result = mutableListOf<String>()
            var before = prev.first()
            var count = 1
            for (i in 1 until prev.length) {
                val cur = prev[i]
                if (before == cur) {
                    count++
                } else {
                    result.add("$count$before")
                    before = cur
                    count = 1
                }
            }
            result.add("$count$before")
            return result.joinToString("")
        }
    }
}
