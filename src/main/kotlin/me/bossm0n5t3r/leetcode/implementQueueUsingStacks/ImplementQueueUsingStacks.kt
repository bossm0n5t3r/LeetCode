package me.bossm0n5t3r.leetcode.implementQueueUsingStacks

import java.util.Stack

class ImplementQueueUsingStacks {
    class MyQueue {
        private val pushStack = Stack<Int>()
        private val popStack = Stack<Int>()

        fun push(x: Int) {
            pushStack.push(x)
        }

        fun pop(): Int {
            peek()
            return popStack.pop()
        }

        fun peek(): Int {
            if (popStack.isEmpty()) {
                while (pushStack.isNotEmpty()) {
                    popStack.push(pushStack.pop())
                }
            }
            return popStack.peek()
        }

        fun empty(): Boolean {
            return pushStack.isEmpty() && popStack.isEmpty()
        }
    }
}
