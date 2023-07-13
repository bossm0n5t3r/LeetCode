package me.bossm0n5t3r.leetcode.longestSubarrayOf1SAfterDeletingOneElement

class LongestSubarrayOf1SAfterDeletingOneElement {
    class Solution {
        fun longestSubarray(nums: IntArray): Int {
            var (s, e) = 0 to 0
            var deleteOnce = 1
            while (e < nums.size) {
                if (nums[e] == 0) {
                    deleteOnce--
                }
                if (deleteOnce < 0) {
                    if (nums[s] == 0) {
                        deleteOnce++
                    }
                    s++
                }
                e++
            }
            return e - s - 1
        }
    }
}
