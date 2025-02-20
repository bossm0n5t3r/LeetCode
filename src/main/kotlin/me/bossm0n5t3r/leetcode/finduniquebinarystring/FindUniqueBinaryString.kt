package me.bossm0n5t3r.leetcode.finduniquebinarystring

class FindUniqueBinaryString {
    class Solution {
        fun findDifferentBinaryString(nums: Array<String>): String {
            val sb = StringBuilder()
            for (i in nums.indices) {
                if (nums[i][i] == '1') {
                    sb.append('0')
                } else {
                    sb.append('1')
                }
            }
            return sb.toString()
        }
    }
}
