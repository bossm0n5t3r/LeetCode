package reverseLinkedList

import utils.ListNode

class ReverseLinkedList {
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
