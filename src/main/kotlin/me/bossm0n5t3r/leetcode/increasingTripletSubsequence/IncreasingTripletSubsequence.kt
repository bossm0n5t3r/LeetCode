package me.bossm0n5t3r.leetcode.increasingTripletSubsequence

class IncreasingTripletSubsequence {
    class Solution {
        fun increasingTriplet(nums: IntArray): Boolean {
            if (nums.toSet().size < 3) return false
            val length = nums.size
            var (start, end) = 0 to length - 1
            while (start < end) {
                var cnt = 0
                for (j in start + 1 until end) {
                    if (nums[start] < nums[j] && nums[j] < nums[end]) return true
                    if (nums[j] < nums[end]) cnt++
                }
                if (cnt >= 2) start++ else end--
            }
            return false
        }
    }
}
