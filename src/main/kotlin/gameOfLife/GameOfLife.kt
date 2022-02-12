package gameOfLife

class GameOfLife {
    fun gameOfLife(board: Array<IntArray>) {
        val m = board.size
        val n = board.first().size
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                val liveNeighborCells = checkLiveNeighbors(board, m, n, r, c)
                if (liveNeighborCells == 3 || (board[r][c] == 1 && liveNeighborCells == 2)) {
                    board[r][c] = board[r][c] or 2
                }
            }
        }
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                board[r][c] = board[r][c] ushr 1
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
            if ((nr in 0 until m) && (nc in 0 until n)) {
                liveCells += (board[nr][nc] and 1)
            }
        }
        return liveCells
    }
}
