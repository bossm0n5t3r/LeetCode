package me.bossm0n5t3r.leetcode.maximumdistanceinarrays

class MaximumDistanceInArrays {
    class Solution {
        fun maxDistance(arrays: List<List<Int>>): Int {
            var result = 0
            var globalMax = arrays[0][arrays[0].size - 1]
            var globalMin = arrays[0][0]
            for (i in 1 until arrays.size) {
                val curMin = arrays[i][0]
                val curMax = arrays[i][arrays[i].size - 1]

                result = maxOf(result, maxOf(abs(globalMax - curMin), abs(globalMin - curMax)))

                globalMax = maxOf(globalMax, curMax)
                globalMin = minOf(globalMin, curMin)
            }
            return result
        }

        private fun abs(number: Int): Int = if (number >= 0) number else -number
    }
}
