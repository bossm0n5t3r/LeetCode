package me.bossm0n5t3r.leetcode.longestnicesubarray

class LongestNiceSubarray {
    class Solution {
        fun longestNiceSubarray(nums: IntArray): Int {
            var e = 0
            var result = 0
            while (e < nums.size) {
                val tmp = mutableListOf(nums[e])
                var index = e
                while (index + 1 < nums.size) {
                    val next = nums[index + 1]
                    var isNice = true
                    for (element in tmp) {
                        if (element and next != 0) {
                            isNice = false
                            break
                        }
                    }
                    if (isNice.not()) break
                    tmp.add(next)
                    index++
                }
                result = maxOf(result, tmp.size)
                e++
            }
            return result
        }
    }
}
