package me.bossm0n5t3r.leetcode.countnumberofbadpairs

class CountNumberOfBadPairs {
    class Solution {
        fun countBadPairs(nums: IntArray): Long {
            val n = nums.size
            val total = n.toLong() * (n.toLong() - 1) / 2

            var good = 0L
            val countMap = mutableMapOf<Int, Long>()

            for (i in 0 until n) {
                val diff = nums[i] - i
                val count = countMap[diff] ?: 0
                good += count
                countMap[diff] = count + 1
            }

            return total - good
        }
    }
}
