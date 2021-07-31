package wordSearch

import java.util.Stack


class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board.first().size
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (board[r][c] == word[0]) {
                    val stack = Stack<Pair<Int, Int>>()
                    stack.add(Pair(r, c))
                    if (dfs(board, word, stack)) return true
                }
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, word: String, stack: Stack<Pair<Int, Int>>): Boolean {
        var index = 0
        val dr = listOf(0, 0, 1, -1)
        val dc = listOf(1, -1, 0, 0)
        val m = board.size
        val n = board.first().size
        val visited = Array(m) { BooleanArray(n) }
        while (stack.isNotEmpty()) {
            val (r, c) = stack.pop()
            if (!visited[r][c]) {
                println("r: $r, c: $c")
                index++
                if (index == word.length) return true
                visited[r][c] = true
                for (i in 0..3) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (nr in 0 until m && nc in 0 until n && board[nr][nc] == word[index]) {
                        stack.push(Pair(nr, nc))
                    }
                }
            }
        }
        return false
    }
}
