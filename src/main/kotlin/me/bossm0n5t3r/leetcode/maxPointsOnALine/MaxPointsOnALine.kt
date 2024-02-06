package me.bossm0n5t3r.leetcode.maxPointsOnALine

class MaxPointsOnALine {
    class Solution {
        fun maxPoints(points: Array<IntArray>): Int {
            if (points.size <= 2) {
                return points.size
            }
            var result = 0
            for (i in points.indices) {
                val map = mutableMapOf<Double, Int>()
                for (j in points.indices) {
                    if (i == j) continue
                    val gradient =
                        if (points[j][0] == points[i][0]) {
                            Double.POSITIVE_INFINITY
                        } else {
                            (points[i][1] - points[j][1]).toDouble() / (points[i][0] - points[j][0])
                        }
                    map[gradient] = map.getOrDefault(gradient, 0) + 1
                }
                result = maxOf(result, map.values.maxOrNull()?.plus(1) ?: 0)
            }
            return result
        }
    }
}
