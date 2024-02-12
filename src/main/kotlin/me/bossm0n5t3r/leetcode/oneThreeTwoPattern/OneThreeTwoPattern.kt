package me.bossm0n5t3r.leetcode.oneThreeTwoPattern

import java.util.Stack

class OneThreeTwoPattern {
    class Solution {
        fun find132pattern(nums: IntArray): Boolean {
            val monotonicStack = Stack<Int>()
            var kMax = Int.MIN_VALUE
            for (i in nums.lastIndex downTo 0) {
                val num = nums[i]
                if (num < kMax) {
                    return true
                }
                while (monotonicStack.isNotEmpty() && monotonicStack.peek() < num) {
                    kMax = maxOf(kMax, monotonicStack.peek())
                    monotonicStack.pop()
                }
                monotonicStack.add(num)
            }
            return false
        }
    }
}
