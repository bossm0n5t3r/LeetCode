package deleteNodeInALinkedList

class DeleteNodeInALinkedList(
    val head: ListNode
) {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`!!
        node.next = node.next?.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
