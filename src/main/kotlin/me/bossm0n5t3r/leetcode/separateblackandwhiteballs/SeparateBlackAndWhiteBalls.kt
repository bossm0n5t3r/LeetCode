package me.bossm0n5t3r.leetcode.separateblackandwhiteballs

class SeparateBlackAndWhiteBalls {
    class Solution {
        fun minimumSteps(s: String): Long {
            if (s.length <= 1) return 0L
            val dp = LongArray(s.length)
            var countOne = 0
            for (i in 1 until s.length) {
                if (i == 1) {
                    countOne = s.substring(0..1).count { it == '1' }
                    dp[i] = if (s[0] == '1' && s[1] == '0') 1 else 0
                    continue
                }
                dp[i] =
                    if (s[i] == '0') {
                        dp[i - 1] + countOne
                    } else {
                        countOne++
                        dp[i - 1]
                    }
            }
            return dp[s.lastIndex]
        }
    }
}
