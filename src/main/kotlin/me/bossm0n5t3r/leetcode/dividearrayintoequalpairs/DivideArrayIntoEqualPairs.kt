package me.bossm0n5t3r.leetcode.dividearrayintoequalpairs

class DivideArrayIntoEqualPairs {
    class Solution {
        fun divideArray(nums: IntArray): Boolean = nums.sorted().chunked(2).all { it[0] == it[1] }
    }
}
