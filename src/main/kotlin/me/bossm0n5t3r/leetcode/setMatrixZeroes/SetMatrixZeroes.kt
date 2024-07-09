package me.bossm0n5t3r.leetcode.setMatrixZeroes

class SetMatrixZeroes {
    class Solution {
        fun setZeroes(matrix: Array<IntArray>) {
            val zeroesSet = mutableSetOf<Pair<Int, Int>>()
            val (m, n) = matrix.size to matrix[0].size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (matrix[r][c] == 0) zeroesSet.add(r to c)
                }
            }
            for ((targetR, targetC) in zeroesSet) {
                for (c in 0 until n) matrix[targetR][c] = 0
                for (r in 0 until m) matrix[r][targetC] = 0
            }
        }
    }
}
