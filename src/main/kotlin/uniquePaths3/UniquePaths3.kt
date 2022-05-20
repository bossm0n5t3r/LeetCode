package uniquePaths3

import java.util.LinkedList

class UniquePaths3 {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size
        lateinit var start: String
        lateinit var end: String
        val emptySquares = mutableSetOf<String>()
        val obstacles = mutableSetOf<String>()
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                val point = "$r$c"
                when (grid[r][c]) {
                    0 -> {
                        emptySquares.add(point)
                    }
                    1 -> {
                        start = point
                    }
                    2 -> {
                        end = point
                    }
                    -1 -> {
                        obstacles.add(point)
                    }
                }
            }
        }
        val dr = intArrayOf(0, 0, 1, -1)
        val dc = intArrayOf(1, -1, 0, 0)
        var result = 0
        val queue = LinkedList<Pair<String, MutableSet<String>>>()
        val notVisited = emptySquares.toMutableSet()
        notVisited.add(end)
        queue.add(start to notVisited)
        while (queue.isNotEmpty()) {
            val (curPoint, willVisited) = queue.poll()
            if (willVisited.isEmpty() && curPoint == end) {
                result++
                continue
            }
            val r = curPoint[0].digitToInt()
            val c = curPoint[1].digitToInt()
            (0 until 4).forEach { i ->
                val nr = r + dr[i]
                val nc = c + dc[i]
                val next = "$nr$nc"
                if ((0 until m).contains(nr) && (0 until n).contains(nc) && willVisited.contains(next)) {
                    val nextWillVisited = willVisited.toMutableSet()
                    nextWillVisited.remove(next)
                    queue.add(next to nextWillVisited)
                }
            }
        }
        return result
    }
}
