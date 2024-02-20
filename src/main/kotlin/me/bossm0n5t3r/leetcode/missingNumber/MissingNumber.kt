package me.bossm0n5t3r.leetcode.missingNumber

class MissingNumber {
    class Solution {
        fun missingNumber(nums: IntArray): Int {
            return (nums.size * (nums.size + 1) / 2) - nums.sum()
        }
    }
}
