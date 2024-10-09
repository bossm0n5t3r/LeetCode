package me.bossm0n5t3r.leetcode.minimumaddtomakeparenthesesvalid

import java.util.Stack

class MinimumAddToMakeParenthesesValid {
    class Solution {
        fun minAddToMakeValid(s: String): Int {
            val result = Stack<Char>()
            for (c in s) {
                if (c == ')' && result.isNotEmpty() && result.peek() == '(') {
                    result.pop()
                    continue
                }
                result.push(c)
            }
            return result.size
        }
    }
}
