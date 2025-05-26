package me.bossm0n5t3r.leetcode.findminimumtimetoreachlastroomi

import java.util.PriorityQueue

class FindMinimumTimeToReachLastRoomI {
    class Solution {
        fun minTimeToReach(moveTime: Array<IntArray>): Int {
            val (m, n) = moveTime.size to moveTime.first().size
            val visited = Array(m) { BooleanArray(n) { false } }
            val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { triple -> triple.third })
            pq.offer(Triple(0, 0, 0))
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)
            while (pq.isNotEmpty()) {
                val (curR, curC, curTime) = pq.poll()
                visited[curR][curC] = true
                if (curR == m - 1 && curC == n - 1) {
                    return curTime
                }
                for (i in 0 until 4) {
                    val nr = curR + dr[i]
                    val nc = curC + dc[i]
                    if (nr in 0 until m && nc in 0 until n && visited[nr][nc].not()) {
                        visited[nr][nc] = true
                        pq.offer(Triple(nr, nc, (curTime).coerceAtLeast(moveTime[nr][nc]) + 1))
                    }
                }
            }
            return 0
        }
    }
}
