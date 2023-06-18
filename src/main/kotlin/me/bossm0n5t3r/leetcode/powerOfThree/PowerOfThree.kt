package me.bossm0n5t3r.leetcode.powerOfThree

class PowerOfThree {
    class Solution {
        fun isPowerOfThree(n: Int): Boolean {
            if (n < 1) return false
            var number = n
            while (number % 3 == 0) {
                number /= 3
            }
            return number == 1
        }

        fun isPowerOfThreeUsingMathematics(n: Int): Boolean {
            // 3^19 = 1162261467
            return n > 0 && 1162261467 % n == 0
        }
    }
}
