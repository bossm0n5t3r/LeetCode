package intersectionOfTwoLinkedLists

import utils.ListNode

class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var currA = headA
        var currB = headB
        while (currA != currB) {
            currA = if (currA == null) headB else currA.next
            currB = if (currB == null) headA else currB.next
        }
        return currA
    }
}
