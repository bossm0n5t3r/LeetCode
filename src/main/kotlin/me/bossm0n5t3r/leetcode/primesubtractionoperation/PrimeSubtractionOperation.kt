package me.bossm0n5t3r.leetcode.primesubtractionoperation

class PrimeSubtractionOperation {
    class Solution {
        fun primeSubOperation(nums: IntArray): Boolean {
            var prev = 0
            for (num in nums) {
                var tmp = num
                if (tmp <= prev) {
                    return false
                }
                val i = binarySearch(tmp - prev) - 1
                if (i != -1) {
                    tmp -= candidatePrimes[i]
                }
                prev = tmp
            }
            return true
        }

        private fun binarySearch(target: Int): Int {
            var left = 0
            var right = candidatePrimes.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (candidatePrimes[mid] < target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        private val candidatePrimes = (1..1000).filter { isPrime(it) }

        private fun isPrime(num: Int): Boolean {
            if (num <= 1) return false
            if (num == 2) return true
            if (num == 3) return true
            var tmp = 2
            while (tmp * tmp <= num) {
                if (num % tmp == 0) {
                    return false
                }
                tmp++
            }
            return true
        }
    }
}
