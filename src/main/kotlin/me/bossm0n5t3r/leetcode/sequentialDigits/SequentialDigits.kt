package me.bossm0n5t3r.leetcode.sequentialDigits

class SequentialDigits {
    class Solution {
        fun sequentialDigits(
            low: Int,
            high: Int,
        ): List<Int> {
            return (low.toString().length..high.toString().length)
                .flatMap { n -> generateSequentialDigits(n) }
                .filter { it in low..high }
        }

        private fun generateSequentialDigits(n: Int): List<Int> {
            return (1..9).windowed(n).map { it.joinToString("").toInt() }
        }
    }
}
