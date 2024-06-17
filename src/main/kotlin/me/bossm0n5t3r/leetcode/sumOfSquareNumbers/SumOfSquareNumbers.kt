package me.bossm0n5t3r.leetcode.sumOfSquareNumbers

class SumOfSquareNumbers {
    class Solution {
        fun judgeSquareSum(c: Int): Boolean {
            val saved = mutableSetOf<Int>()
            var a = 0
            while (a * a <= c) {
                if (a * a < 0) return false
                saved.add(a * a)
                val b = c - a * a
                if (saved.contains(b)) return true
                a++
            }
            return false
        }
    }
}
