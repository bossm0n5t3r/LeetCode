package me.bossm0n5t3r.leetcode.convertbinarynumberinalinkedlisttointeger

import me.bossm0n5t3r.leetcode.utils.ListNode

class ConvertBinaryNumberInALinkedListToInteger {
    class Solution {
        fun getDecimalValue(head: ListNode?): Int {
            val sb = StringBuilder()
            var tmp = head
            while (tmp != null) {
                sb.append(tmp.`val`)
                tmp = tmp.next
            }
            return sb.toString().toInt(2)
        }
    }
}
