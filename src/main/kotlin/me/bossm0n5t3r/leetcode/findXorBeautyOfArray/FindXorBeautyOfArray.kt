package me.bossm0n5t3r.leetcode.findXorBeautyOfArray

class FindXorBeautyOfArray {
    class Solution {
        fun xorBeauty(nums: IntArray): Int = nums.reduce { acc, i -> acc xor i }
    }
}
