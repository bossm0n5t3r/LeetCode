package wordSearch

import java.util.LinkedList
import java.util.Queue


class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board.first().size
        val dr = listOf(0, 0, 1, -1)
        val dc = listOf(1, -1, 0, 0)
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (board[r][c] == word[0]) {
                    val visited = Array(m) { BooleanArray(n) }
                    if (dfs(board, word, dr, dc, m, n, Pair(r, c), visited, 0)) return true
                }
            }
        }
        return false
    }

    private fun dfs(
        board: Array<CharArray>,
        word: String,
        dr: List<Int>,
        dc: List<Int>,
        m: Int,
        n: Int,
        cur: Pair<Int, Int>,
        visited: Array<BooleanArray>,
        index: Int
    ): Boolean {
        if (index == word.length) return true
        val (r, c) = cur
        if (!visited[r][c]) {
            visited[r][c] = true
            println("r: $r, c: $c")
            for (i in 0..3) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr in 0 until m && nc in 0 until n && !visited[nr][nc] && board[nr][nc] == word[index]) {
                    dfs(board, word, dr, dc, m, n, Pair(nr, nc), visited, index + 1)
                }
            }
        }
        return false
    }

    fun existByBfs(board: Array<CharArray>, word: String): Boolean {
        // 시작 위치를 큐에 넣어둔다.
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val dr = listOf(0, 0, 1, -1)
        val dc = listOf(1, -1, 0, 0)
        var index = 0
        val m = board.size
        val n = board.first().size
        val visited = Array(m) { BooleanArray(n) }
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (board[r][c] == word[index]) {
                    queue.add(Pair(r, c))
                }
            }
        }
        while (queue.isNotEmpty()) {
            // 큐에서 꺼낸 글자와 word의 마지막 인덱스면 성공을 리턴, 아니면 실패
            val size = queue.size
            index++
            if (index == word.length) return true
            (0 until size).forEach { _ ->
                // 큐에서 꺼내면서, 인접한 위치에 다음 인덱스의 char가 있는지 확인하고, 있으면 그 위치를 넣어준다.
                val (r, c) = queue.poll()
                visited[r][c] = true
                for (i in 0..3) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (nr in 0 until m && nc in 0 until n && !visited[nr][nc] && board[nr][nc] == word[index]) {
                        queue.add(Pair(nr, nc))
                    }
                }
            }
        }
        return false
    }
}

