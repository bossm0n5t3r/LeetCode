package utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class ListNodeUtil {
    fun generateListNodeFromList(head: List<Int>): ListNode? {
        if (head.isEmpty()) return null
        val length = head.size
        val result = ListNode(head[0])
        var cur = result
        for (i in 1 until length) {
            cur.next = ListNode(head[i])
            cur = cur.next!!
        }
        return result
    }

    fun findListNodeByValue(value: Int, head: ListNode): ListNode {
        var cur = head
        while (cur.`val` != value) {
            cur = cur.next!!
        }
        return cur
    }

    fun listNodeToList(listNode: ListNode?): List<Int> {
        val result = mutableListOf<Int>()
        var cur: ListNode? = listNode
        while (cur != null) {
            result.add(cur.`val`)
            cur = cur.next
        }
        return result
    }

    fun isEqual(first: ListNode?, second: ListNode?): Boolean {
        if (first == null && second == null) return true
        var curFirst: ListNode? = first
        var curSecond: ListNode? = second
        while (curFirst != null && curSecond != null) {
            if (curFirst.`val` != curSecond.`val`) return false
            if (curFirst.next == null && curSecond.next == null) return true
            curFirst = curFirst.next
            curSecond = curSecond.next
        }
        return false
    }
}
