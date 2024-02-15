package me.bossm0n5t3r.leetcode.rearrangeArrayElementsBySign

class RearrangeArrayElementsBySign {
    class Solution {
        fun rearrangeArray(nums: IntArray): IntArray {
            var positiveIndex = 0
            var negativeIndex = 1
            val result = IntArray(nums.size) { Int.MAX_VALUE }
            for (num in nums) {
                if (num > 0) {
                    result[positiveIndex] = num
                    positiveIndex += 2
                } else {
                    result[negativeIndex] = num
                    negativeIndex += 2
                }
            }
            return result
        }
    }
}
