package me.bossm0n5t3r.leetcode.reorderlist

import me.bossm0n5t3r.leetcode.utils.ListNode

class ReorderList {
    class Solution {
        fun reorderList(head: ListNode?) {
            head?.toList()?.reorder()?.toListNode()
        }

        private fun ListNode.toList(): List<ListNode> {
            val result = mutableListOf<ListNode>()
            var tmp = this as ListNode?
            while (tmp != null) {
                result.add(tmp)
                tmp = tmp.next
            }
            return result
        }

        private fun List<ListNode>.reorder(): List<ListNode> {
            val n = this.size
            val result = mutableListOf<ListNode>()
            val natural = this
            val reversed = this.reversed()
            var index = 0
            while (index < n) {
                result.add(if (index % 2 == 0) natural[index / 2] else reversed[index / 2])
                index++
            }
            return result
        }

        private fun List<ListNode>.toListNode() {
            val head = this.first()
            var tmp = head as ListNode?
            var index = 1
            while (index < this.size) {
                tmp?.next = this[index++]
                tmp = tmp?.next
            }
            tmp?.next = null
        }
    }
}
