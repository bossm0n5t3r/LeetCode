package me.bossm0n5t3r.leetcode.stringcompressioniii

class StringCompressionIII {
    class Solution {
        private fun Char.toIndex() = this - 'a'

        fun compressedString(word: String): String {
            val countArray = IntArray(26)
            val comp = StringBuilder()
            var prev = word.first()
            for (c in word) {
                countArray[c.toIndex()]++
                if (prev != c) {
                    if (countArray[prev.toIndex()] != 0) {
                        comp.append("${countArray[prev.toIndex()]}$prev")
                        countArray[prev.toIndex()] = 0
                    }
                    prev = c
                    continue
                }
                if (countArray[c.toIndex()] == 9) {
                    comp.append("9$c")
                    countArray[c.toIndex()] = 0
                }
            }
            if (countArray[prev.toIndex()] != 0) {
                comp.append("${countArray[prev.toIndex()]}$prev")
            }
            return comp.toString()
        }
    }
}
