package me.bossm0n5t3r.leetcode.heightChecker

class HeightChecker {
    class Solution {
        fun heightChecker(heights: IntArray): Int {
            return heights.zip(heights.sorted()).count { it.first != it.second }
        }
    }
}
