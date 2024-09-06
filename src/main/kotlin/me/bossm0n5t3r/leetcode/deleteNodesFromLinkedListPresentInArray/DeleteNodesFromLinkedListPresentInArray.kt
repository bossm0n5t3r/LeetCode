package me.bossm0n5t3r.leetcode.deleteNodesFromLinkedListPresentInArray

import me.bossm0n5t3r.leetcode.utils.ListNode

class DeleteNodesFromLinkedListPresentInArray {
    class Solution {
        fun modifiedList(
            nums: IntArray,
            head: ListNode?,
        ): ListNode? {
            val numberSet = nums.toSet()
            return head?.toList()?.filterNot { numberSet.contains(it) }?.toListNode()
        }

        private fun ListNode.toList(): List<Int> {
            val result = mutableListOf<Int>()
            var tmp = this as ListNode?
            while (tmp != null) {
                result.add(tmp.`val`)
                tmp = tmp.next
            }
            return result
        }

        private fun List<Int>.toListNode(): ListNode? {
            if (this.isEmpty()) return null
            val result = ListNode(this.first())
            var tmp = result as ListNode?
            for (i in 1 until this.size) {
                tmp?.next = ListNode(this[i])
                tmp = tmp?.next
            }
            return result
        }
    }
}
