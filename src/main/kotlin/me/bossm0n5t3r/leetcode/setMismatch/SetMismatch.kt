package me.bossm0n5t3r.leetcode.setMismatch

class SetMismatch {
    class Solution {
        fun findErrorNums(nums: IntArray): IntArray {
            val set = (1..nums.size).toMutableSet()
            var duplicated = 0
            for (num in nums) {
                if (set.remove(num).not()) {
                    duplicated = num
                }
            }
            return intArrayOf(duplicated, set.first())
        }
    }
}
