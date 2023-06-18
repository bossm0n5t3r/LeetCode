package me.bossm0n5t3r.leetcode.singleNumber

class SingleNumber {
    class Solution {
        fun singleNumber(nums: IntArray): Int {
            for (i in 1 until nums.size) {
                nums[0] = nums[0].xor(nums[i])
            }
            return nums[0]
        }
    }
}
