package me.bossm0n5t3r.leetcode.shortestUnsortedContinuousSubarray

class ShortestUnsortedContinuousSubarray {
    class Solution {
        fun findUnsortedSubarray(nums: IntArray): Int {
            var e = -1
            var max = nums.first()
            (1 until nums.size).forEach { i ->
                if (nums[i] < max) {
                    e = i
                } else {
                    max = nums[i]
                }
            }
            var s = 0
            var min = nums.last()
            (nums.size - 2 downTo 0).forEach { i ->
                if (nums[i] > min) {
                    s = i
                } else {
                    min = nums[i]
                }
            }
            return (e - s + 1)
        }
    }
}
