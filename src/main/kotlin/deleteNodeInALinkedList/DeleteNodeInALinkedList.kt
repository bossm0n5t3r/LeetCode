package deleteNodeInALinkedList

import utils.ListNode

class DeleteNodeInALinkedList(
    val head: ListNode
) {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`!!
        node.next = node.next?.next
    }
}
