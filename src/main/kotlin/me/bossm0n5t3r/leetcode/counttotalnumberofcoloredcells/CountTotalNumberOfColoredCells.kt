package me.bossm0n5t3r.leetcode.counttotalnumberofcoloredcells

class CountTotalNumberOfColoredCells {
    class Solution {
        fun coloredCells(n: Int): Long {
            val longN = n.toLong()
            return longN * longN + (longN - 1) * (longN - 1)
        }
    }
}
