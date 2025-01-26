package me.bossm0n5t3r.leetcode.findeventualsafestates

class FindEventualSafeStates {
    class Solution {
        fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
            val n = graph.size
            val color = IntArray(n)
            val result = mutableListOf<Int>()

            fun dfs(node: Int): Boolean {
                if (color[node] > 0) {
                    return color[node] == 2
                }

                color[node] = 1
                for (neighbor in graph[node]) {
                    if (color[neighbor] == 2) {
                        continue
                    }

                    if (color[neighbor] == 1 || !dfs(neighbor)) {
                        return false
                    }
                }

                color[node] = 2
                return true
            }

            for (i in 0 until n) {
                if (dfs(i)) {
                    result.add(i)
                }
            }

            return result
        }
    }
}
