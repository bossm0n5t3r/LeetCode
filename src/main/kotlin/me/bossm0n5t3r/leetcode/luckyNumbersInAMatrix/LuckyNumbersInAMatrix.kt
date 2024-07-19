package me.bossm0n5t3r.leetcode.luckyNumbersInAMatrix

class LuckyNumbersInAMatrix {
    class Solution {
        fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
            val minRow = IntArray(matrix.size) { Int.MAX_VALUE }
            val maxCol = IntArray(matrix[0].size) { Int.MIN_VALUE }
            val result = mutableListOf<Int>()
            val (m, n) = matrix.size to matrix[0].size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    minRow[r] = minOf(matrix[r][c], minRow[r])
                    maxCol[c] = maxOf(matrix[r][c], maxCol[c])
                }
            }
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (matrix[r][c] == minRow[r] && matrix[r][c] == maxCol[c]) {
                        result.add(matrix[r][c])
                    }
                }
            }
            return result
        }
    }
}
