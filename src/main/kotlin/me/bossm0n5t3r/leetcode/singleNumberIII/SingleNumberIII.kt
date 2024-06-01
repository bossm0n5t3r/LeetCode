package me.bossm0n5t3r.leetcode.singleNumberIII

class SingleNumberIII {
    class Solution {
        fun singleNumber(nums: IntArray): IntArray {
            val result = mutableSetOf<Int>()
            for (num in nums) {
                if (!result.contains(num)) result.add(num) else result.remove(num)
            }
            return result.toIntArray()
        }
    }
}
