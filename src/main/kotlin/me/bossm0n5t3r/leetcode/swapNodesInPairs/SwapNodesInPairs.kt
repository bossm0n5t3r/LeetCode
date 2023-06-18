package me.bossm0n5t3r.leetcode.swapNodesInPairs

import me.bossm0n5t3r.leetcode.utils.ListNode

class SwapNodesInPairs {
    class Solution {
        fun swapPairs(head: ListNode?): ListNode? {
            var first: ListNode? = head
            var second: ListNode? = head?.next
            val result = head?.next ?: return first
            while (second != null) {
                val tmpFirst = first?.next?.next
                val tmpSecond = second.next?.next ?: tmpFirst
                second.next = first
                first?.next = tmpSecond
                second = tmpSecond
                first = tmpFirst
            }
            return result
        }
    }
}
