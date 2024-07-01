package me.bossm0n5t3r.leetcode.threeConsecutiveOdds

class ThreeConsecutiveOdds {
    class Solution {
        fun threeConsecutiveOdds(arr: IntArray): Boolean {
            var countConsecutiveOdds = 0
            for (i in arr.indices) {
                if (arr[i] % 2 == 0) {
                    countConsecutiveOdds = 0
                    continue
                }
                countConsecutiveOdds++
                if (countConsecutiveOdds == 3) return true
            }
            return false
        }
    }
}
