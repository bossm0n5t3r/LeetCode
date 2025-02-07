package me.bossm0n5t3r.leetcode.tuplewithsameproduct

class TupleWithSameProduct {
    class Solution {
        fun tupleSameProduct(nums: IntArray): Int {
            val productToCandidatePairs = mutableMapOf<Int, Int>()
            val n = nums.size
            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    val key = nums[i] * nums[j]
                    productToCandidatePairs[key] = productToCandidatePairs.getOrDefault(key, 0) + 1
                }
            }
            var result = 0
            for (value in productToCandidatePairs.values) {
                result += value * (value - 1) * 4
            }
            return result
        }
    }
}
