package me.bossm0n5t3r.leetcode.findCenterOfStarGraph

class FindCenterOfStarGraph {
    class Solution {
        fun findCenter(edges: Array<IntArray>): Int {
            val (u, v) = edges.first()
            return if (edges.last().contains(u)) u else v
        }
    }
}
