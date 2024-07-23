package me.bossm0n5t3r.leetcode.lengthOfLastWord

class LengthOfLastWord {
    class Solution {
        fun lengthOfLastWord(s: String): Int {
            return s.trim().split(" ").last().length
        }
    }
}
