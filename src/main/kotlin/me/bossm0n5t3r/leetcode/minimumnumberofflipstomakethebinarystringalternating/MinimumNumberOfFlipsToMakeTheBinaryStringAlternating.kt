package me.bossm0n5t3r.leetcode.minimumnumberofflipstomakethebinarystringalternating

class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
    class Solution {
        fun minFlips(s: String): Int {
            val n = s.length
            val pre = Array(n) { IntArray(2) }

            for (i in 0 until n) {
                val ch = s[i]
                // Compute the prefix array
                pre[i][0] = (if (i == 0) 0 else pre[i - 1][1]) + (if (ch == '1') 1 else 0)
                pre[i][1] = (if (i == 0) 0 else pre[i - 1][0]) + (if (ch == '0') 1 else 0)
            }

            var result = minOf(pre[n - 1][0], pre[n - 1][1])
            // If the length is odd, consider the move operation
            if (n % 2 == 1) {
                val suf = Array(n) { IntArray(2) }
                for (i in n - 1 downTo 0) {
                    val ch = s[i]
                    // Suffix Array Construction
                    suf[i][0] = (if (i == n - 1) 0 else suf[i + 1][1]) + (if (ch == '1') 1 else 0)
                    suf[i][1] = (if (i == n - 1) 0 else suf[i + 1][0]) + (if (ch == '0') 1 else 0)
                }

                // Traverse all split points
                for (i in 0 until n - 1) {
                    result = minOf(result, pre[i][0] + suf[i + 1][0])
                    result = minOf(result, pre[i][1] + suf[i + 1][1])
                }
            }

            return result
        }
    }
}
