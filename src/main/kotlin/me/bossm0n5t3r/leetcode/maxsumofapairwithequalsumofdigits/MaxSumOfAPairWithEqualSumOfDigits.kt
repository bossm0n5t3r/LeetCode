package me.bossm0n5t3r.leetcode.maxsumofapairwithequalsumofdigits

class MaxSumOfAPairWithEqualSumOfDigits {
    class Solution {
        fun maximumSum(nums: IntArray): Int {
            val cache = mutableMapOf<Int, Int>()
            var result = -1
            for (num in nums) {
                val key = num.sumOfDigits()
                val prev = cache[key]

                if (prev == null) {
                    cache[key] = num
                    continue
                }

                result = maxOf(result, prev + num)
                cache[key] = maxOf(prev, num)
            }
            return result
        }

        private fun Int.sumOfDigits(): Int = this.toString().sumOf { it.digitToInt() }
    }
}
