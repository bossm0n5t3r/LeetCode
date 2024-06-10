package me.bossm0n5t3r.leetcode.heightChecker

class HeightChecker {
    class Solution {
        fun heightChecker(heights: IntArray): Int {
            val heightsSize = heights.size
            var prefixSum = 0

            for (i in 0 until heightsSize) {
                prefixSum = maxOf(prefixSum, heights[i])
            }

            val countArray = IntArray(prefixSum + 1)

            for (i in 0 until heightsSize) {
                countArray[heights[i]]++
            }

            for (i in 1..prefixSum) {
                countArray[i] += countArray[i - 1]
            }

            val outputArray = IntArray(heightsSize)

            for (i in heightsSize - 1 downTo 0) {
                outputArray[countArray[heights[i]] - 1] = heights[i]
                countArray[heights[i]]--
            }

            return heights.zip(outputArray).count { it.first != it.second }
        }
    }
}
