package me.bossm0n5t3r.leetcode.divideintervalsintominimumnumberofgroups

class DivideIntervalsIntoMinimumNumberOfGroups {
    class Solution {
        fun minGroups(intervals: Array<IntArray>): Int {
            val (startTimes, endTimes) = intervals.map { it.first() to it.last() }.unzip()
            val sortedStartTimes = startTimes.sorted()
            val sortedEndTimes = endTimes.sorted()

            var endPoint = 0
            var groupCount = 0
            for (start in sortedStartTimes) {
                if (start > sortedEndTimes[endPoint]) {
                    endPoint++
                } else {
                    groupCount++
                }
            }

            return groupCount
        }
    }
}
