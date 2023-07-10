package me.bossm0n5t3r.leetcode.maximumAverageSubarrayI

class MaximumAverageSubarrayI {
    class Solution {
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var tmp = nums.take(k).sum().toDouble()
            var maxAverage = tmp / k
            for (i in 0 until nums.size - k) {
                val tmpAverage = tmp / k
                if (tmpAverage > maxAverage) maxAverage = tmpAverage
                tmp -= nums[i]
                tmp += nums[i + k]
            }
            val tmpAverage = tmp / k
            if (tmpAverage > maxAverage) maxAverage = tmpAverage
            return maxAverage
        }
    }
}
