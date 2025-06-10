package me.bossm0n5t3r.leetcode.maximumdifferencebetweenevenandoddfrequencyi

class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    class Solution {
        fun maxDifference(s: String): Int {
            val frequency = IntArray(26) { 0 }
            for (c in s) {
                frequency[c - 'a']++
            }
            var minEven = Int.MAX_VALUE
            var maxOdd = Int.MIN_VALUE
            for (freq in frequency) {
                if (freq % 2 == 1) {
                    maxOdd = maxOf(maxOdd, freq)
                } else if (freq > 0) {
                    minEven = minOf(minEven, freq)
                }
            }
            // println("maxOdd: $maxOdd, minEven: $minEven")
            return maxOdd - minEven
        }
    }
}
