package me.bossm0n5t3r.leetcode.maximumdifferencebetweenincreasingelements

class MaximumDifferenceBetweenIncreasingElements {
    class Solution {
        fun maximumDifference(nums: IntArray): Int {
            var min = Int.MAX_VALUE
            var result = -1
            for (num in nums) {
                if (num <= min) {
                    min = num
                } else {
                    result = maxOf(num - min, result)
                }
            }
            return result
        }
    }
}
