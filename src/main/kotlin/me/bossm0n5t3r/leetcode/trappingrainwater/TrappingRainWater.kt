package me.bossm0n5t3r.leetcode.trappingrainwater

class TrappingRainWater {
    class Solution {
        fun trap(height: IntArray): Int {
            val n = height.size
            var leftIndex = 0
            var rightIndex = n - 1
            var leftMax = height[leftIndex]
            var rightMax = height[rightIndex]
            var water = 0

            while (leftIndex < rightIndex) {
                if (leftMax < rightMax) {
                    leftIndex++
                    leftMax = maxOf(leftMax, height[leftIndex])
                    water += leftMax - height[leftIndex]
                } else {
                    rightIndex--
                    rightMax = maxOf(rightMax, height[rightIndex])
                    water += rightMax - height[rightIndex]
                }
            }

            return water
        }
    }
}
