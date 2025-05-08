package me.bossm0n5t3r.leetcode.findnumberswithevennumberofdigits

class FindNumbersWithEvenNumberOfDigits {
    class Solution {
        fun findNumbers(nums: IntArray): Int = nums.count { it.toString().length % 2 == 0 }
    }
}
