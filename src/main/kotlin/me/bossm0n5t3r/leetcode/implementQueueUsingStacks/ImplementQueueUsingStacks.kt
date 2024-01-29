package me.bossm0n5t3r.leetcode.implementQueueUsingStacks

import java.util.Stack

class ImplementQueueUsingStacks {
    class MyQueue {
        private val stack = Stack<Int>()
        private val subStack = Stack<Int>()

        fun push(x: Int) {
            stack.push(x)
        }

        fun pop(): Int {
            while (stack.isNotEmpty()) {
                subStack.push(stack.pop())
            }
            val result = subStack.pop()
            while (subStack.isNotEmpty()) {
                stack.push(subStack.pop())
            }
            return result
        }

        fun peek(): Int {
            return stack.elementAt(0)
        }

        fun empty(): Boolean {
            return stack.isEmpty()
        }
    }
}
