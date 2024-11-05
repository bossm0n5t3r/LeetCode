package me.bossm0n5t3r.leetcode.minimumnumberofchangestomakebinarystringbeautiful

class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    class Solution {
        fun minChanges(s: String): Int = (s.indices step 2).count { s[it] != s[it + 1] }
    }
}
