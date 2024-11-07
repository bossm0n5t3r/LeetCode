package me.bossm0n5t3r.leetcode.checkbalancedstring

class CheckBalancedString {
    class Solution {
        fun isBalanced(num: String): Boolean {
            var even = 0
            var odd = 0
            for (i in num.indices) {
                if (i % 2 == 0) {
                    even += num[i].digitToInt()
                } else {
                    odd += num[i].digitToInt()
                }
            }
            return even == odd
        }
    }
}
