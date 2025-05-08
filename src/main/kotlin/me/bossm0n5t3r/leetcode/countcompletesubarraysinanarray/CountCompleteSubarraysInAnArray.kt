package me.bossm0n5t3r.leetcode.countcompletesubarraysinanarray

class CountCompleteSubarraysInAnArray {
    class Solution {
        fun countCompleteSubarrays(nums: IntArray): Int {
            var count = 0
            val distinctNumberCount = nums.toSet().size
            val numToCount = mutableMapOf<Int, Int>()
            var start = 0
            var end = 0
            while (end < nums.size) {
                while (end < nums.size && numToCount.keys.size != distinctNumberCount) {
                    val number = nums[end++]
                    numToCount[number] = numToCount.getOrDefault(number, 0) + 1
                }
                if (numToCount.keys.size == distinctNumberCount) {
                    count += (nums.size - end + 1)
                }
                while (start < end && numToCount.keys.size == distinctNumberCount) {
                    val out = nums[start++]
                    val previous = numToCount[out] ?: error("Not found number: $out")
                    if (previous == 1) {
                        numToCount.remove(out)
                    } else {
                        numToCount[out] = previous - 1
                        count += (nums.size - end + 1)
                    }
                }
            }
            return count
        }
    }
}
