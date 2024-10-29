package me.bossm0n5t3r.leetcode.longestsquarestreakinanarray

class LongestSquareStreakInAnArray {
    class Solution {
        fun longestSquareStreak(nums: IntArray): Int {
            val sortedNum = nums.sorted()
            val numsSet = nums.toSet()
            var result = -1
            var index = 0
            while (index < sortedNum.size) {
                if (sortedNum[index] * sortedNum[index] > sortedNum.last()) break
                var count = 1
                var cur = sortedNum[index]
                while (numsSet.contains(cur * cur)) {
                    cur *= cur
                    count++
                }
                if (count >= 2) {
                    result = maxOf(result, count)
                }
                index++
            }
            return result
        }
    }
}
