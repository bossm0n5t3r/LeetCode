package me.bossm0n5t3r.leetcode.minimumRemoveToMakeValidParentheses

import java.util.Stack

class MinimumRemoveToMakeValidParentheses {
    class Solution {
        fun minRemoveToMakeValid(s: String): String {
            val openParenthesisIndexStack = Stack<Int>()
            val result = CharArray(s.length) { ' ' }
            for (index in s.indices) {
                val c = s[index]
                if (c == '(') {
                    openParenthesisIndexStack.push(index)
                    continue
                }
                if (c == ')') {
                    if (openParenthesisIndexStack.isNotEmpty()) {
                        result[openParenthesisIndexStack.pop()] = '('
                        result[index] = ')'
                    }
                    continue
                }
                result[index] = c
            }
            return result.filterNot { it == ' ' }.joinToString(separator = "")
        }
    }
}
