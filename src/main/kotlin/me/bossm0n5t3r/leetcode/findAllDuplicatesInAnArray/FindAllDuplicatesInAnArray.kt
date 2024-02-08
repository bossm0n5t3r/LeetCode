package me.bossm0n5t3r.leetcode.findAllDuplicatesInAnArray

class FindAllDuplicatesInAnArray {
    class Solution {
        fun findDuplicates(nums: IntArray): List<Int> {
            val set = mutableSetOf<Int>()
            val result = mutableListOf<Int>()
            for (num in nums) {
                if (set.contains(num)) {
                    set.remove(num)
                    result.add(num)
                } else {
                    set.add(num)
                }
            }
            return result
        }
    }
}
