package me.bossm0n5t3r.leetcode.trionicarrayi

class TrionicArrayI {
    class Solution {
        fun isTrionic(nums: IntArray): Boolean {
            return nums
                .toList()
                .windowed(2)
                .map { (cur, next) ->
                    if (cur == next) return false
                    if (next > cur) 1 else 0
                }.joinToString("")
                .replace(Regex("1+"), "1")
                .replace(Regex("0+"), "0") == "101"
        }
    }
}
