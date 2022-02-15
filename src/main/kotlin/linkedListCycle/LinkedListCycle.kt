package linkedListCycle

import utils.ListNode

class LinkedListCycle {
    fun hasCycleFirstApproach(head: ListNode?): Boolean {
        val set = mutableSetOf<ListNode?>()
        var cur: ListNode? = head
        while (cur != null) {
            if (set.contains(cur)) {
                return true
            }
            set.add(cur)
            cur = cur.next
        }
        return false
    }

    fun hasCycleSecondApproach(head: ListNode?): Boolean {
        var cur: ListNode? = head
        while (cur != null) {
            if (cur.`val` == Int.MAX_VALUE) return true
            cur.`val` = Int.MAX_VALUE
            cur = cur.next
        }
        return false
    }

    fun hasCycleThirdApproach(head: ListNode?): Boolean {
        if (head == null) return false
        var slow = head
        var fast = head
        while (slow?.next != null && fast?.next?.next != null) {
            slow = slow.next
            fast = fast.next!!.next
            if (slow == fast) return true
        }
        return false
    }
}
