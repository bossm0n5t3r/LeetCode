package me.bossm0n5t3r.leetcode.lettertilepossibilities

class LetterTilePossibilities {
    class Solution {
        fun numTilePossibilities(tiles: String): Int {
            val count = IntArray(26)
            for (c in tiles.toCharArray()) {
                count[c - 'A']++
            }
            return dfs(count)
        }

        private fun dfs(count: IntArray): Int {
            var sum = 0
            for (i in count.indices) {
                if (count[i] == 0) {
                    continue
                }
                sum++
                count[i]--
                sum += dfs(count)
                count[i]++
            }
            return sum
        }
    }
}
