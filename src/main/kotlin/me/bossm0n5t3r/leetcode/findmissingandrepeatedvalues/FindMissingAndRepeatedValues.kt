package me.bossm0n5t3r.leetcode.findmissingandrepeatedvalues

class FindMissingAndRepeatedValues {
    class Solution {
        fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
            val n = grid.size.toLong()
            val visited = mutableSetOf<Int>()
            var total = ((n * n) * (n * n + 1)) / 2
            var duplicated = -1
            for (row in grid) {
                for (num in row) {
                    if (visited.contains(num).not()) {
                        visited += num
                        total -= num
                    } else {
                        duplicated = num
                    }
                }
            }
            return intArrayOf(duplicated, total.toInt())
        }
    }
}
