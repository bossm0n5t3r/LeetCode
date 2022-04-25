package sudokuSolver

class SudokuSolverFaster {
    fun solveSudoku(board: Array<CharArray>) {
        solve(board, 0, 0)
    }

    private fun solve(board: Array<CharArray>, row: Int, column: Int): Boolean {
        var col = column
        for (i in row until 9) {
            for (j in col until 9) {
                if (board[i][j] != '.') {
                    continue
                }

                for (c in '1'..'9') {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c
                        if (solve(board, i, j + 1)) {
                            return true
                        }
                        board[i][j] = '.'
                    }
                }
                return false
            }
            col = 0
        }
        return true
    }

    private fun isValid(board: Array<CharArray>, row: Int, column: Int, c: Char): Boolean {
        val blockRow = (row / 3) * 3
        val blockColumn = (column / 3) * 3

        for (i in 0 until 9) {
            if (board[i][column] == c ||
                board[row][i] == c ||
                board[blockRow + (i / 3)][blockColumn + (i % 3)] == c
            ) {
                return false
            }
        }
        return true
    }
}
