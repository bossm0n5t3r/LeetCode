package me.bossm0n5t3r.leetcode.existenceOfASubstringInAStringAndItsReverse

class ExistenceOfASubstringInAStringAndItsReverse {
    class Solution {
        fun isSubstringPresent(s: String): Boolean {
            val windowed = s.windowed(2)
            val reversed = s.reversed().windowed(2).toSet()
            for (windowedSubstring in windowed) {
                if (reversed.contains(windowedSubstring)) return true
            }
            return false
        }
    }
}
