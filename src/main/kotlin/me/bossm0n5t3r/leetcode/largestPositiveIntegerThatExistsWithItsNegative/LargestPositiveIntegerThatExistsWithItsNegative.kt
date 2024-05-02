package me.bossm0n5t3r.leetcode.largestPositiveIntegerThatExistsWithItsNegative

class LargestPositiveIntegerThatExistsWithItsNegative {
    class Solution {
        fun findMaxK(nums: IntArray): Int {
            val numsSet = nums.toSet()
            var result = -1
            for (num in nums) {
                if (num > 0 && numsSet.contains(-num) && result < num) {
                    result = num
                }
            }
            return result
        }
    }
}
