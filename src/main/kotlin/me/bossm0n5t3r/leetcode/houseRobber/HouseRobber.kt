package me.bossm0n5t3r.leetcode.houseRobber

class HouseRobber {
    class Solution {
        fun rob(nums: IntArray): Int {
            val length = nums.size
            val arr = IntArray(length)
            for (i in 0 until length) {
                when (i) {
                    0 -> {
                        arr[i] = nums[i]
                    }
                    1 -> {
                        arr[i] = max(nums[i], arr[i - 1])
                    }
                    else -> {
                        arr[i] = max(nums[i] + arr[i - 2], arr[i - 1])
                    }
                }
            }
            return arr[length - 1]
        }

        private fun max(a: Int, b: Int): Int {
            return if (a > b) {
                a
            } else {
                b
            }
        }
    }
}
