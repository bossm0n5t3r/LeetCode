package me.bossm0n5t3r.leetcode.candy

class Candy {
    class Solution {
        fun candy(ratings: IntArray): Int {
            val left2Right = IntArray(ratings.size) { 1 }
            val right2Left = IntArray(ratings.size) { 1 }
            for (i in 1 until ratings.size) {
                left2Right[i] = if (ratings[i - 1] >= ratings[i]) 1 else left2Right[i - 1] + 1
            }
            for (i in ratings.size - 2 downTo 0) {
                right2Left[i] = if (ratings[i + 1] >= ratings[i]) 1 else right2Left[i + 1] + 1
            }
            return left2Right.zip(right2Left).sumOf { maxOf(it.first, it.second) }
        }
    }
}
