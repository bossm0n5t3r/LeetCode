package me.bossm0n5t3r.leetcode.runningSumOf1dArray

class RunningSumOf1dArray {
    class Solution {
        fun runningSum(nums: IntArray): IntArray {
            var before = 0
            nums.forEachIndexed { index, i ->
                val tmp = before + i
                nums[index] = tmp
                before = tmp
            }
            return nums
        }
    }
}
