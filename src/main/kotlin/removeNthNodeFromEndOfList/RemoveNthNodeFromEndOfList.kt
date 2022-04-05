package removeNthNodeFromEndOfList

import utils.ListNode

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val valueList = mutableListOf<Int>()
        var cur = head
        while (cur != null) {
            valueList.add(cur.`val`)
            cur = cur.next
        }
        val valueListSize = valueList.size
        valueList.removeAt(valueListSize - n)
        if (valueList.isEmpty()) return null
        val result = ListNode(valueList.first())
        var curResult = result
        (1 until valueListSize - 1).forEach { i ->
            curResult.next = ListNode(valueList[i])
            curResult = curResult.next!!
        }
        return result
    }
}
