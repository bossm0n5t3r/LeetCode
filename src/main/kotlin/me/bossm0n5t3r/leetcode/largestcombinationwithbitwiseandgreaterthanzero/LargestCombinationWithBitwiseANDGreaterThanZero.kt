package me.bossm0n5t3r.leetcode.largestcombinationwithbitwiseandgreaterthanzero

class LargestCombinationWithBitwiseANDGreaterThanZero {
    class Solution {
        fun largestCombination(candidates: IntArray): Int {
            var result = 0
            for (i in 0..31) {
                var count = 0
                for (candidate in candidates) {
                    if ((candidate and (1 shl i)) != 0) count++
                }
                result = maxOf(result, count)
            }
            return result
        }
    }
}
