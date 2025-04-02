package me.bossm0n5t3r.leetcode.maximumvalueofanorderedtripleti

class MaximumValueOfAnOrderedTripletI {
    class Solution {
        fun maximumTripletValue(nums: IntArray): Long {
            var result = 0L
            val n = nums.size
            for (i in 0 until n - 2) {
                for (j in i + 1 until n - 1) {
                    if (nums[i] <= nums[j]) continue
                    for (k in j + 1 until n) {
                        if (nums[k] <= 0) continue
                        result = maxOf(result, (nums[i] - nums[j]) * nums[k].toLong())
                    }
                }
            }
            return result
        }
    }
}
