package me.bossm0n5t3r.leetcode.splitastringintothemaxnumberofuniquesubstrings

class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    class Solution {
        fun maxUniqueSplit(s: String): Int {
            val result = intArrayOf(0)
            dfs(s, 0, mutableSetOf(), 0, result)
            return result.first()
        }

        private fun dfs(
            s: String,
            index: Int,
            history: MutableSet<String>,
            count: Int,
            result: IntArray,
        ) {
            if (count + (s.length - index) <= result.first()) return

            if (index == s.length) {
                result[0] = maxOf(result[0], history.size)
                return
            }
            for (i in index + 1..s.length) {
                val tmp = s.substring(index, i)
                if (history.contains(tmp).not()) {
                    history.add(tmp)
                    dfs(s, i, history, count + 1, result)
                    history.remove(tmp)
                }
            }
        }
    }
}
