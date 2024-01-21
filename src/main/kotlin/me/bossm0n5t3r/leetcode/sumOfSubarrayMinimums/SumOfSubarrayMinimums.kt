package me.bossm0n5t3r.leetcode.sumOfSubarrayMinimums

class SumOfSubarrayMinimums {
    class Solution {
        fun sumSubarrayMins(arr: IntArray): Int {
            val modulo = 1_000_000_007L
            val size = arr.size
            var result = 0L
            for (r in 0 until size) {
                var tmpMin = arr[r]
                for (c in r until size) {
                    if (tmpMin > arr[c]) {
                        tmpMin = arr[c]
                    }
                    result += tmpMin
                }
            }
            return (result % modulo).toInt()
        }
    }
}
