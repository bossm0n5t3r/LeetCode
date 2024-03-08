package me.bossm0n5t3r.leetcode.middleOfTheLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode

class MiddleOfTheLinkedList {
    class Solution {
        fun middleNode(head: ListNode?): ListNode? {
            var fast = head
            var slow = head
            while (fast?.next != null) {
                fast = fast.next?.next
                slow = slow?.next
            }
            return slow
        }
    }
}
