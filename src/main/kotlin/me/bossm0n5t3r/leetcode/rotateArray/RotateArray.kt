package me.bossm0n5t3r.leetcode.rotateArray

class RotateArray {
    class Solution {
        fun rotateOne(
            nums: IntArray,
            k: Int,
        ) {
            repeat(k) { rotateClockwise(nums) }
        }

        private fun rotateClockwise(nums: IntArray) {
            val tmp = nums[nums.lastIndex]
            for (i in nums.lastIndex downTo 1) {
                nums[i] = nums[i - 1]
            }
            nums[0] = tmp
        }
    }
}
