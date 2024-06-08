package me.bossm0n5t3r.leetcode.continuousSubarraySum

class ContinuousSubarraySum {
    class Solution {
        fun checkSubarraySum(
            nums: IntArray,
            k: Int,
        ): Boolean {
            if (nums.size < 2) return false
            val prefixSumIntArray = IntArray(nums.size) { nums[0] % k }
            for (i in 1 until nums.size) {
                prefixSumIntArray[i] = (prefixSumIntArray[i - 1] + nums[i]) % k
                if (prefixSumIntArray[i] == 0) return true
            }
            val prefixSumToIndex =
                prefixSumIntArray
                    .toList()
                    .mapIndexed { index, prefixSum -> prefixSum to index }
                    .groupBy { it.first }
                    .mapValues { (_, value) -> value.map { it.second }.sorted() }
            val sortedPrefixSumKeys = prefixSumToIndex.keys.sorted()
            for (sortedPrefixSum in sortedPrefixSumKeys) {
                val source = prefixSumToIndex[sortedPrefixSum] ?: continue
                if (source.size >= 3) {
                    for (i in 0 until source.size - 2) {
                        if (source[i + 1] - source[i] == 1 && source[i + 2] - source[i + 1] == 1) return true
                    }
                }

                if (prefixSumToIndex.containsKey((sortedPrefixSum + k) % k).not()) continue
                val target = prefixSumToIndex[(sortedPrefixSum + k) % k] ?: continue
                for (i in source) {
                    for (j in target) {
                        if (i + 1 < j || j + 1 < i) return true
                    }
                }
            }
            return false
        }
    }
}
