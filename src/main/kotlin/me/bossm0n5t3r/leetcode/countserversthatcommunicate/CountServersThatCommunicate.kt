package me.bossm0n5t3r.leetcode.countserversthatcommunicate

class CountServersThatCommunicate {
    class Solution {
        fun countServers(grid: Array<IntArray>): Int {
            val (m, n) = grid.size to grid.first().size
            val rows = IntArray(m)
            val cols = IntArray(n)
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == 1) {
                        rows[r]++
                        cols[c]++
                    }
                }
            }
            var result = 0
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == 1 && (rows[r] > 1 || cols[c] > 1)) {
                        result++
                    }
                }
            }
            return result
        }
    }
}
