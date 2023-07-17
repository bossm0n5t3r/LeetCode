package me.bossm0n5t3r.leetcode.decodeString

class DecodeString {
    class Solution {
        private val numbers = '0'..'9'

        fun decodeString(s: String): String {
            val result = StringBuilder()
            val stack = StringBuilder()
            var idx = 0
            while (idx < s.length) {
                when (val c = s[idx]) {
                    in numbers -> {
                        stack.append(c)
                    }
                    '[' -> {
                        val tmp = StringBuilder()
                        tmp.append(c)
                        idx++
                        var brackets = 1
                        while (idx < s.length && brackets != 0) {
                            val curChar = s[idx++]
                            if (curChar == '[') {
                                brackets++
                            } else if (curChar == ']') {
                                brackets--
                            }
                            tmp.append(curChar)
                        }
                        tmp.deleteCharAt(0)
                        tmp.deleteCharAt(tmp.lastIndex)
                        repeat(stack.toString().toInt()) {
                            result.append(tmp)
                        }
                        stack.clear()
                        idx--
                    }
                    else -> {
                        result.append(c)
                    }
                }
                idx++
            }
            return if (result.contains('[')) decodeString(result.toString()) else result.toString()
        }
    }
}
