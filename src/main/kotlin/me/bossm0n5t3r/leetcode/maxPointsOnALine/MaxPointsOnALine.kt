package me.bossm0n5t3r.leetcode.maxPointsOnALine

class MaxPointsOnALine {
    class Solution {
        fun maxPoints(points: Array<IntArray>): Int {
            if (points.size <= 2) {
                return points.size
            }
            val sortedPoints = points.sortedWith(compareBy({ it[0] }, { it[1] }))
            var result = 0
            for (i in sortedPoints.indices) {
                val map = mutableMapOf<Double, Int>()
                for (j in sortedPoints.indices) {
                    if (i == j) continue
                    val gradient =
                        if (sortedPoints[j][0] == sortedPoints[i][0]) {
                            Double.POSITIVE_INFINITY
                        } else {
                            if (j <= i) {
                                (sortedPoints[i][1] - sortedPoints[j][1]).toDouble() / (sortedPoints[i][0] - sortedPoints[j][0])
                            } else {
                                (sortedPoints[j][1] - sortedPoints[i][1]).toDouble() / (sortedPoints[j][0] - sortedPoints[i][0])
                            }
                        }
                    map[gradient] = map.getOrDefault(gradient, 0) + 1
                }
                result = maxOf(result, map.values.maxOrNull()?.plus(1) ?: 0)
            }
            return result
        }
    }
}
