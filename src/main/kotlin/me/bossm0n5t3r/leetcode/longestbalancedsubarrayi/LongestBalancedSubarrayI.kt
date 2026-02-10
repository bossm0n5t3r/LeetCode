package me.bossm0n5t3r.leetcode.longestbalancedsubarrayi

class LongestBalancedSubarrayI {
    class Solution {
        fun longestBalanced(nums: IntArray): Int {
            var length = 0
            for (i in 0..<nums.size) {
                val odd = mutableMapOf<Int, Int>()
                val even = mutableMapOf<Int, Int>()

                for (j in i..<nums.size) {
                    val map = if ((nums[j] and 1) == 1) odd else even
                    map[nums[j]] = map.getOrDefault(nums[j], 0) + 1

                    if (odd.size == even.size) {
                        length = maxOf(length, j - i + 1)
                    }
                }
            }
            return length
        }
    }
}
