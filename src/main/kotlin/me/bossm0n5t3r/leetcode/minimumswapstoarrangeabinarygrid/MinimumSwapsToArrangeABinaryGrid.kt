package me.bossm0n5t3r.leetcode.minimumswapstoarrangeabinarygrid

class MinimumSwapsToArrangeABinaryGrid {
    class Solution {
        fun minSwaps(grid: Array<IntArray>): Int {
            val n = grid.size
            val pos = IntArray(n) { -1 }
            for (i in 0 until n) {
                for (j in n - 1 downTo 0) {
                    if (grid[i][j] == 1) {
                        pos[i] = j
                        break
                    }
                }
            }
            var result = 0
            for (i in 0 until n) {
                var k = -1
                for (j in i until n) {
                    if (pos[j] <= i) {
                        result += j - i
                        k = j
                        break
                    }
                }
                if (k < 0) return -1
                for (j in k downTo i + 1) {
                    val tmp = pos[j]
                    pos[j] = pos[j - 1]
                    pos[j - 1] = tmp
                }
            }
            return result
        }
    }
}
