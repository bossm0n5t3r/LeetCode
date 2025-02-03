package me.bossm0n5t3r.leetcode.longeststrictlyincreasingorstrictlydecreasingsubarray

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    class Solution {
        fun longestMonotonicSubarray(nums: IntArray): Int =
            maxOf(
                findLongestMonotonicSubArrayLength(nums, true),
                findLongestMonotonicSubArrayLength(nums, false),
            )

        private fun findLongestMonotonicSubArrayLength(
            nums: IntArray,
            isStrictlyIncreasing: Boolean,
        ): Int {
            var result = 0
            var index = 0
            while (index < nums.size) {
                var count = 1
                var cur = nums[index]
                for (i in index + 1 until nums.size) {
                    if (isStrictlyIncreasing && nums[i] <= cur) break
                    if (isStrictlyIncreasing.not() && nums[i] >= cur) break
                    cur = nums[i]
                    count++
                }
                result = maxOf(result, count)
                index++
            }
            return result
        }
    }
}
