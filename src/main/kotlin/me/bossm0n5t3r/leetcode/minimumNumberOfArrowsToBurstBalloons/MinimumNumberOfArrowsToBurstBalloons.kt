package me.bossm0n5t3r.leetcode.minimumNumberOfArrowsToBurstBalloons

class MinimumNumberOfArrowsToBurstBalloons {
    class Solution {
        fun findMinArrowShots(points: Array<IntArray>): Int {
            if (points.isEmpty()) return 0
            val sortedPoints = points.sortedBy { it[1] }
            var count = 1
            var arrow = sortedPoints[0][1]
            for (i in 1 until sortedPoints.size) {
                if (arrow < sortedPoints[i][0]) {
                    count++
                    arrow = sortedPoints[i][1]
                }
            }
            return count
        }
    }
}
