package oddEvenLinkedList

import utils.ListNode

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        var cur = head
        var tail = head.next
        val tailHead = tail
        while (tail?.next != null) {
            cur?.next = cur?.next!!.next
            tail.next = tail.next?.next
            tail = tail.next
            cur = cur.next
        }
        cur?.next = tailHead
        return head
    }
}
