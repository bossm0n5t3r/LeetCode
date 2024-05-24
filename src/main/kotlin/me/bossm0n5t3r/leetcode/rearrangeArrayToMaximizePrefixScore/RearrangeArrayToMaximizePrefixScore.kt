package me.bossm0n5t3r.leetcode.rearrangeArrayToMaximizePrefixScore

class RearrangeArrayToMaximizePrefixScore {
    class Solution {
        fun maxScore(nums: IntArray): Int {
            val descendingSortedNums = nums.sortedByDescending { it }
            var prefix = 0L
            for (i in descendingSortedNums.indices) {
                if (prefix + descendingSortedNums[i] <= 0) {
                    return i
                }
                prefix += descendingSortedNums[i]
            }
            return descendingSortedNums.size
        }
    }
}
