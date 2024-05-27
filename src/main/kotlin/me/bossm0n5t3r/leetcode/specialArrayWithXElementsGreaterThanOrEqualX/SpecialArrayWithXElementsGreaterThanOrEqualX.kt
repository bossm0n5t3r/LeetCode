package me.bossm0n5t3r.leetcode.specialArrayWithXElementsGreaterThanOrEqualX

class SpecialArrayWithXElementsGreaterThanOrEqualX {
    class Solution {
        fun specialArray(nums: IntArray): Int {
            val sortedNums = nums.sorted()
            val maxNum = sortedNums.last()
            for (i in 0..maxNum) {
                val count = sortedNums.count { it >= i }
                if (count == i) {
                    return i
                }
            }
            return -1
        }
    }
}
