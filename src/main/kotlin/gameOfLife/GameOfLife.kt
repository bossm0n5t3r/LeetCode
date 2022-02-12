package gameOfLife

class GameOfLife {
    fun gameOfLife(board: Array<IntArray>) {
        val m = board.size
        val n = board.first().size
        val becomeDie = mutableListOf<Pair<Int, Int>>()
        val becomeLive = mutableListOf<Pair<Int, Int>>()
        (0 until m).forEach { r ->
            (0 until n).forEach { c ->
                val curPoint = Pair(r, c)
                val curCell = board[r][c]
                val liveNeighborCells = checkLiveNeighbors(board, m, n, r, c)
                if (curCell == 1) {
                    when {
                        // Any live cell with fewer than two live neighbors dies as if caused by under-population.
                        liveNeighborCells < 2 -> becomeDie.add(curPoint)
                        // Any live cell with two or three live neighbors lives on to the next generation.
                        liveNeighborCells in 2..3 -> becomeLive.add(curPoint)
                        // Any live cell with more than three live neighbors dies, as if by over-population.
                        liveNeighborCells > 3 -> becomeDie.add(curPoint)
                    }
                } else {
                    // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    if (liveNeighborCells == 3) {
                        becomeLive.add(curPoint)
                    } else {
                        becomeDie.add(curPoint)
                    }
                }
            }
        }
        becomeLive.forEach { (r, c) -> board[r][c] = 1 }
        becomeDie.forEach { (r, c) -> board[r][c] = 0 }
    }

    private fun checkLiveNeighbors(board: Array<IntArray>, m: Int, n: Int, r: Int, c: Int): Int {
        var liveCells = 0
        val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
        (0..7).forEach { i ->
            val nr = r + dr[i]
            val nc = c + dc[i]
            if ((nr in 0 until m) && (nc in 0 until n) && board[nr][nc] == 1) {
                liveCells++
            }
        }
        return liveCells
    }
}
