package me.bossm0n5t3r.leetcode.jumpgame

class JumpGame {
    class Solution {
        fun canJump(nums: IntArray): Boolean {
            var goal = nums.size - 1
            for (i in nums.size - 2 downTo 0) {
                if (i + nums[i] >= goal) goal = i
            }
            return goal == 0
        }
    }
}
