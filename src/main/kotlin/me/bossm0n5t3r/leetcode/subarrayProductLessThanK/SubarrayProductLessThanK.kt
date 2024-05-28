package me.bossm0n5t3r.leetcode.subarrayProductLessThanK

class SubarrayProductLessThanK {
    class Solution {
        fun numSubarrayProductLessThanK(
            nums: IntArray,
            k: Int,
        ): Int {
            var result = 0
            for (start in nums.indices) {
                var product = nums[start]
                if (product >= k) {
                    continue
                }
                result++
                var end = start + 1
                while (end < nums.size && product * nums[end] < k) {
                    product *= nums[end++]
                    result++
                }
            }
            return result
        }
    }
}
