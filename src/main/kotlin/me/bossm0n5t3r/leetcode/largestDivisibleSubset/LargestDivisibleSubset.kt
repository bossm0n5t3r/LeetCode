package me.bossm0n5t3r.leetcode.largestDivisibleSubset

class LargestDivisibleSubset {
    class Solution {
        fun largestDivisibleSubset(nums: IntArray): List<Int> {
            val sortedNums = nums.sorted()
            val dp = IntArray(sortedNums.size) { 1 }
            val prev = IntArray(sortedNums.size) { -1 }
            var (maxValue, maxIndex) = 0 to 0
            for (i in 1 until sortedNums.size) {
                for (j in 0 until i) {
                    if (sortedNums[i] % sortedNums[j] == 0) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1
                            prev[i] = j
                        }
                    }
                }
                if (dp[i] > maxValue) {
                    maxValue = dp[i]
                    maxIndex = i
                }
            }
            val result = mutableListOf<Int>()
            while (maxIndex != -1) {
                result.add(sortedNums[maxIndex])
                maxIndex = prev[maxIndex]
            }
            return result
        }
    }
}
