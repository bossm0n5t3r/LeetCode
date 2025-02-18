package me.bossm0n5t3r.leetcode.constructsmallestnumberfromdistring

import java.util.Stack

class ConstructSmallestNumberFromDIString {
    class Solution {
        fun smallestNumber(pattern: String): String {
            val sb = StringBuilder()
            val numberStack = Stack<Int>()
            for (i in 0..pattern.length) {
                numberStack.push(i + 1)
                if (i == pattern.length || pattern[i] == 'I') {
                    while (numberStack.isNotEmpty()) {
                        sb.append(numberStack.pop())
                    }
                }
            }
            return sb.toString()
        }
    }
}
