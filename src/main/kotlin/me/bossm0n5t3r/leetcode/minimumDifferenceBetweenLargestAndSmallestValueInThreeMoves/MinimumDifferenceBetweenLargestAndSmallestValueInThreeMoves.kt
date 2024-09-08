package me.bossm0n5t3r.leetcode.minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    class Solution {
        fun minDifference(nums: IntArray): Int {
            if (nums.size <= 4) return 0
            val sortedNums = nums.sorted()
            val candidates =
                if (nums.size >= 6) {
                    sortedNums.take(3) + sortedNums.takeLast(3)
                } else {
                    sortedNums
                }
            val maxIndex = candidates.lastIndex
            var result = Int.MAX_VALUE
            for (i in 0..maxIndex - 2) {
                for (j in i + 1..maxIndex - 1) {
                    for (k in j + 1..maxIndex) {
                        val tmp = sortedNums - candidates[i] - candidates[j] - candidates[k]
                        result = minOf(result, tmp.max() - tmp.min())
                    }
                }
            }
            return result
        }
    }
}
