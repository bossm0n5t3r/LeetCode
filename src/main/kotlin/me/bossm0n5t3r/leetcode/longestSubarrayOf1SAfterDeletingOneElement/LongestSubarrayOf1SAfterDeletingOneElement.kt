package me.bossm0n5t3r.leetcode.longestSubarrayOf1SAfterDeletingOneElement

class LongestSubarrayOf1SAfterDeletingOneElement {
    class Solution {
        fun longestSubarray(nums: IntArray): Int {
            var tmp = 0
            var removeZero = true
            var idx = 0
            while (idx < nums.size) {
                if (nums[idx] == 1) {
                    tmp++
                } else if (removeZero) {
                    tmp++
                    removeZero = false
                } else {
                    break
                }
                idx++
            }
            var (s, e) = 0 to idx
            var result = tmp
            while (e < nums.size) {
                if (nums[e] == 1) {
                    tmp++
                    while (e + 1 < nums.size && nums[e + 1] == 1) {
                        e++
                        tmp++
                    }
                } else {
                    while (s < e && nums[s] == 1) {
                        s++
                        tmp--
                    }
                    s++
                }
                if (tmp > result) result = tmp
                e++
            }
            return result - 1
        }
    }
}
