package me.bossm0n5t3r.leetcode.luckyNumbersInAMatrix

class LuckyNumbersInAMatrix {
    class Solution {
        fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
            return (matrix to matrix.getMinValueInEachRow()).filterMaxValueInEachColumn()
        }

        private fun Array<IntArray>.getMinValueInEachRow(): List<Pair<Int, Int>> {
            val (m, n) = this.size to this[0].size
            val result = mutableListOf<Pair<Int, Int>>()
            for (r in 0 until m) {
                var minColumnIndex = 0
                var minValue = this[r][minColumnIndex]
                for (c in 0 until n) {
                    if (this[r][c] < minValue) {
                        minColumnIndex = c
                        minValue = this[r][minColumnIndex]
                    }
                }
                result.add(r to minColumnIndex)
            }
            return result
        }

        private fun Pair<Array<IntArray>, List<Pair<Int, Int>>>.filterMaxValueInEachColumn(): List<Int> {
            val (matrix, minValueInEachRow) = this
            val m = matrix.size
            return minValueInEachRow
                .filter { (curR, curC) ->
                    val currentValue = matrix[curR][curC]
                    for (r in 0 until m) {
                        if (matrix[r][curC] > currentValue) return@filter false
                    }
                    true
                }
                .map { (r, c) -> matrix[r][c] }
        }
    }
}
