package me.bossm0n5t3r.leetcode.differentwaystoaddparentheses

class DifferentWaysToAddParentheses {
    class Solution {
        fun diffWaysToCompute(expression: String): List<Int> {
            val result = mutableListOf<Int>()
            for (i in expression.indices) {
                val cur = expression[i]
                if (cur == '+' || cur == '-' || cur == '*') {
                    val left = diffWaysToCompute(expression.substring(0, i))
                    val right = diffWaysToCompute(expression.substring(i + 1, expression.length))
                    for (l in left) {
                        for (r in right) {
                            when (cur) {
                                '+' -> result.add(l + r)
                                '-' -> result.add(l - r)
                                '*' -> result.add(l * r)
                            }
                        }
                    }
                }
            }
            if (result.isEmpty()) {
                result.add(expression.toInt())
            }
            return result
        }
    }
}
