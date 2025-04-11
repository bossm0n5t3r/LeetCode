package me.bossm0n5t3r.leetcode.minimumnumberofoperationstomakeelementsinarraydistinct

class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    class Solution {
        fun minimumOperations(nums: IntArray): Int {
            val distinct = mutableSetOf<Int>()
            for (i in nums.lastIndex downTo 0) {
                val cur = nums[i]
                if (distinct.contains(cur)) {
                    return i / 3 + 1
                }
                distinct += cur
            }
            return 0
        }
    }
}
