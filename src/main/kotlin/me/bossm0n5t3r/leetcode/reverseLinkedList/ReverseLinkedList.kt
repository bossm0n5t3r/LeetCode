package me.bossm0n5t3r.leetcode.reverseLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class ReverseLinkedList {
    class Solution {
        fun reverseList(head: ListNode?): ListNode? {
            if (head?.next == null) return head
            var cur: ListNode? = head
            var last: ListNode? = null
            var newListNode: ListNode
            while (cur != null) {
                newListNode = ListNode(cur.`val`)
                newListNode.next = last
                last = newListNode
                cur = cur.next
            }
            return last
        }
    }
}
