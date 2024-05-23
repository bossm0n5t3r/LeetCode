package me.bossm0n5t3r.leetcode.palindromePartitioning

class PalindromePartitioning {
    class Solution {
        fun partition(s: String): List<List<String>> {
            val result = mutableListOf<MutableList<String>>()
            dfs(s, mutableListOf(), result)
            return result
        }

        private fun dfs(
            remained: String,
            cur: MutableList<String>,
            result: MutableList<MutableList<String>>,
        ) {
            if (remained.isEmpty()) {
                result.add(cur)
                return
            }
            for (i in 1..remained.length) {
                val tmpSubStr = remained.take(i)
                if (tmpSubStr.isPalindrome()) {
                    dfs(remained.substring(i), (cur + tmpSubStr).toMutableList(), result)
                }
            }
        }

        private fun String.isPalindrome() = this == this.reversed()
    }
}
