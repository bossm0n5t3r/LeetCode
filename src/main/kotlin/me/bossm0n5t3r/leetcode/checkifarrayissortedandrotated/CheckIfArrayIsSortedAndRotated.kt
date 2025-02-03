package me.bossm0n5t3r.leetcode.checkifarrayissortedandrotated

class CheckIfArrayIsSortedAndRotated {
    class Solution {
        fun check(nums: IntArray): Boolean {
            val numsList = nums.toList()
            val minimumIndex = findMinimumIndex(numsList)
            return numsList.rotate(minimumIndex) == numsList.sorted()
        }

        private fun findMinimumIndex(nums: List<Int>): Int {
            val minimum = nums.minOrNull() ?: error("Not found minimum")
            var minimumIndex = nums.indexOfFirst { it == minimum }
            if (minimumIndex == 0) {
                var nextMinimumIndex = Int.MIN_VALUE
                var isFirst = true
                for (i in 1 until nums.size) {
                    if (isFirst.not() && nums[i] == minimum) {
                        nextMinimumIndex = i
                        break
                    }
                    if (nums[i] != minimum) {
                        isFirst = false
                    }
                }
                if (nextMinimumIndex != Int.MIN_VALUE) {
                    minimumIndex = nextMinimumIndex
                }
            }
            return minimumIndex
        }

        private fun List<Int>.rotate(n: Int): List<Int> = drop(n) + take(n)
    }
}
