package me.bossm0n5t3r.leetcode.plusOne

class PlusOne {
    class Solution {
        fun plusOne(digits: IntArray): IntArray {
            digits[digits.lastIndex] += 1
            if (digits.last() < 9) {
                return digits
            }
            val digitsSize = digits.size
            val result = mutableListOf<Int>()
            var additionalDigit = 0
            for (i in digitsSize - 1 downTo 0) {
                val cur = digits[i] + additionalDigit
                result.add(0, cur % 10)
                additionalDigit = if (cur > 9) cur / 10 else 0
            }
            if (additionalDigit > 0) result.add(0, additionalDigit)
            return result.toIntArray()
        }
    }
}
