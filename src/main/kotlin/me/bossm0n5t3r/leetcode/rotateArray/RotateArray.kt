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

        fun rotateTwo(
            nums: IntArray,
            k: Int,
        ) {
            val tmp = k % nums.size
            val (modifiedK, sign) =
                if (tmp > nums.size / 2) {
                    nums.size - tmp to 1
                } else {
                    tmp to 0
                }
            repeat(modifiedK) {
                rotateWithSign(nums, sign)
            }
        }

        // sign: 0 - clockwise, 1 - counterclockwise
        private fun rotateWithSign(
            nums: IntArray,
            sign: Int,
        ) {
            if (sign == 0) {
                val tmp = nums[nums.lastIndex]
                for (i in nums.lastIndex downTo 1) {
                    nums[i] = nums[i - 1]
                }
                nums[0] = tmp
            } else {
                val tmp = nums[0]
                for (i in 0 until nums.size - 1) {
                    nums[i] = nums[i + 1]
                }
                nums[nums.lastIndex] = tmp
            }
        }
    }
}
