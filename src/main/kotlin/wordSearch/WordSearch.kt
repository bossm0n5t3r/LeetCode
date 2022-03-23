package wordSearch

import java.util.LinkedList

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (!isPossible(board, word)) return false
        val m = board.size
        val n = board.first().size
        val boardSize = Pair(m, n)
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                if (board[r][c] == word.first()) {
                    if (bfs(Pair(r, c), board, boardSize, word)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun isPossible(board: Array<CharArray>, word: String): Boolean {
        return word.toSet().all {
            board.any { row -> row.contains(it) }
        }
    }

    private fun bfs(
        startPoint: Pair<Int, Int>,
        board: Array<CharArray>,
        boardSize: Pair<Int, Int>,
        word: String
    ): Boolean {
        val (m, n) = boardSize
        val dr = intArrayOf(0, 0, 1, -1)
        val dc = intArrayOf(1, -1, 0, 0)
        val queue = LinkedList<WordPoint>()
        queue.add(WordPoint.from(startPoint))
        while (queue.isNotEmpty()) {
            val (curR, curC, curIdx, visited) = queue.poll()
            if (curIdx == word.length) {
                return true
            }
            (0 until 4).forEach { i ->
                val nr = curR + dr[i]
                val nc = curC + dc[i]
                if ((0 until m).contains(nr) && (0 until n).contains(nc) && !visited.contains(Pair(nr, nc))) {
                    if (board[nr][nc] == word[curIdx]) {
                        queue.add(
                            WordPoint(
                                nr, nc, curIdx + 1,
                                (visited.toMutableSet() + mutableSetOf(Pair(nr, nc))) as MutableSet<Pair<Int, Int>>
                            )
                        )
                    }
                }
            }
        }
        return false
    }

    private data class WordPoint(val r: Int, val c: Int, val curIdx: Int, val visited: MutableSet<Pair<Int, Int>>) {
        companion object {
            fun from(startPoint: Pair<Int, Int>): WordPoint {
                return WordPoint(startPoint.first, startPoint.second, 1, mutableSetOf(startPoint))
            }
        }
    }
}
