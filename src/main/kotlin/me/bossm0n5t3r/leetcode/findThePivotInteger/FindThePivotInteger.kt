package me.bossm0n5t3r.leetcode.findThePivotInteger

class FindThePivotInteger {
    class Solution {
        fun pivotInteger(n: Int): Int {
            val sum = (1 + n) * n / 2
            var result = 1
            while (result * result < sum) {
                result++
            }
            if (result * result != sum) return -1
            return result
        }
    }
}
