package me.bossm0n5t3r.leetcode.lexicographicalnumbers

class LexicographicalNumbers {
    class Solution {
        fun lexicalOrder(n: Int): List<Int> {
            val result = mutableListOf<Int>()
            for (i in 1..9) {
                dfs(n, i, result)
            }
            return result
        }

        private fun dfs(
            n: Int,
            cur: Int,
            result: MutableList<Int>,
        ) {
            if (cur > n) return
            result.add(cur)
            for (i in 0..9) {
                dfs(n, cur * 10 + i, result)
            }
        }
    }
}
