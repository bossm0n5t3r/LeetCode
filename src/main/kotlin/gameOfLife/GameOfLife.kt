package gameOfLife

class GameOfLife {
    fun gameOfLife(board: Array<IntArray>) {
        val m = board.size
        val n = board.first().size
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                val liveNeighborCells = checkLiveNeighbors(board, m, n, r, c)
                board[r][c] += liveNeighborCells * 10
            }
        }
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                if (board[r][c] in setOf(21, 31, 30)) {
                    board[r][c] = 1
                } else {
                    board[r][c] = 0
                }
            }
        }
    }

    private fun checkLiveNeighbors(board: Array<IntArray>, m: Int, n: Int, r: Int, c: Int): Int {
        var liveCells = 0
        val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
        (0..7).forEach { i ->
            val nr = r + dr[i]
            val nc = c + dc[i]
            if ((nr in 0 until m) && (nc in 0 until n) && board[nr][nc] % 10 == 1) {
                liveCells++
            }
        }
        return liveCells
    }
}
