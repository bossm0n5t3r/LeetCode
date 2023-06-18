package me.bossm0n5t3r.leetcode.missingNumber

class MissingNumber {
    class Solution {
        fun missingNumber(nums: IntArray): Int {
            val n = nums.size
            var result = n * (n + 1) / 2
            for (num in nums) {
                result -= num
            }
            return result
        }
    }
}
