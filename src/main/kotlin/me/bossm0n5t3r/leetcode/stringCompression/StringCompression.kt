package me.bossm0n5t3r.leetcode.stringCompression

class StringCompression {
    class Solution {
        fun compress(chars: CharArray): Int {
            if (chars.size == 1) return 1
            val result = StringBuilder()
            var cur = chars[0]
            var cnt = 1
            for (i in 1 until chars.size) {
                if (chars[i] == cur) {
                    cnt++
                } else {
                    result.append(cur)
                    if (cnt > 1) {
                        result.append(cnt.toString())
                    }
                    cur = chars[i]
                    cnt = 1
                }
            }
            result.append(cur)
            if (cnt > 1) {
                result.append(cnt.toString())
            }
            for (i in result.indices) {
                chars[i] = result[i]
            }
            return result.length
        }
    }
}
