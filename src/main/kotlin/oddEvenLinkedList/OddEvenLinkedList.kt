package oddEvenLinkedList

import utils.ListNode

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null || head.next!!.next == null) return head
        var cur = head
        var tail: ListNode? = null
        var tailFirst: ListNode? = null
        while (cur?.next?.next != null) {
            if (tail == null) {
                tail = cur.next
                tailFirst = tail
            } else {
                tail.next = tail.next?.next
                tail = tail.next
            }
            cur.next = cur.next!!.next
            cur = cur.next
        }
        if (tail?.next?.next != null) {
            tail.next = tail.next?.next
            tail = tail.next
        }
        tail?.next = null
        cur?.next = tailFirst
        return head
    }
}
