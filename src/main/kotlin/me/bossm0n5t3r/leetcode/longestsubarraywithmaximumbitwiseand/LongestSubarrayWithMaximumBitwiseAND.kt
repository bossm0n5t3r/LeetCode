package me.bossm0n5t3r.leetcode.longestsubarraywithmaximumbitwiseand

class LongestSubarrayWithMaximumBitwiseAND {
    class Solution {
        fun longestSubarray(nums: IntArray): Int {
            val maximumNumber = nums.max()
            var result = 0
            var index = 0
            while (index < nums.size) {
                if (nums[index] != maximumNumber) {
                    index++
                    continue
                }
                var tmp = 1
                while (index + 1 < nums.size && nums[index + 1] == maximumNumber) {
                    tmp++
                    index++
                }
                result = maxOf(result, tmp)
                index++
            }
            return result
        }
    }
}
