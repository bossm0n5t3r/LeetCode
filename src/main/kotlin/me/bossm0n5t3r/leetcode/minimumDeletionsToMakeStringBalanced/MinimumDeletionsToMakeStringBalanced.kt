package me.bossm0n5t3r.leetcode.minimumDeletionsToMakeStringBalanced

import java.util.Stack

class MinimumDeletionsToMakeStringBalanced {
    class Solution {
        fun minimumDeletions(s: String): Int {
            val stack = Stack<Char>()
            var count = 0
            for (c in s) {
                if (c == 'a' && stack.isNotEmpty() && stack.peek() == 'b') {
                    stack.pop()
                    count++
                    continue
                }
                stack.push(c)
            }
            return count
        }
    }
}
