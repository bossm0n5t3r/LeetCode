package me.bossm0n5t3r.leetcode.maxNumberOfKSumPairs

import kotlin.math.min

class MaxNumberOfKSumPairs {
    class Solution {
        fun maxOperations(nums: IntArray, k: Int): Int {
            val numToCount = getNumToCount(nums)
//            val numToCount = nums
//                .toList()
//                .groupingBy { it }
//                .eachCount()
//                .toMutableMap()
            val sortedKeys = numToCount.keys.sorted()
            var operations = 0
            for (key in sortedKeys) {
                if (numToCount.containsKey(k - key)) {
                    val thisCount = numToCount[key]!!
                    val otherCount = numToCount[k - key]!!
                    if (
                        thisCount > 0 &&
                        otherCount > 0
                    ) {
                        val minCount = if (2 * key == k) {
                            thisCount / 2
                        } else {
                            min(thisCount, otherCount)
                        }
                        operations += minCount
                        numToCount[key] = numToCount[key]!! - minCount
                        numToCount[k - key] = numToCount[k - key]!! - minCount
                    }
                }
                if (2 * key == k) break
            }
            return operations
        }

        private fun getNumToCount(nums: IntArray): MutableMap<Int, Int> {
            val result = mutableMapOf<Int, Int>()
            for (num in nums) {
                result[num] = result.getOrDefault(num, 0) + 1
            }
            return result
        }
    }
}
