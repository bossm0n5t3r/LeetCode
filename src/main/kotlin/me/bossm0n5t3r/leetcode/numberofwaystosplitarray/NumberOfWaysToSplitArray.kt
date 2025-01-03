package me.bossm0n5t3r.leetcode.numberofwaystosplitarray

class NumberOfWaysToSplitArray {
    class Solution {
        fun waysToSplitArray(nums: IntArray): Int {
            val totalSum = nums.sumOf { it.toLong() }
            var prefixSum = 0L
            return nums.dropLast(1).count {
                prefixSum += it
                prefixSum * 2 >= totalSum
            }
        }
    }
}
