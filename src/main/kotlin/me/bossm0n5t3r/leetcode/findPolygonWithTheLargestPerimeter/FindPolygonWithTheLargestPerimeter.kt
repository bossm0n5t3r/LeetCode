package me.bossm0n5t3r.leetcode.findPolygonWithTheLargestPerimeter

class FindPolygonWithTheLargestPerimeter {
    class Solution {
        fun largestPerimeter(nums: IntArray): Long {
            val longNums = nums.map { it.toLong() }
            val sortedLongNums = longNums.sortedDescending()
            var sumLongNums = longNums.sum()
            for (i in sortedLongNums.indices) {
                val cur = sortedLongNums[i]
                if (sumLongNums - cur > cur && sortedLongNums.size - i >= 2) {
                    return sumLongNums
                }
                sumLongNums -= cur
            }
            return -1
        }
    }
}
