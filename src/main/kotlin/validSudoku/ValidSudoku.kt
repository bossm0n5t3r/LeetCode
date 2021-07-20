package validSudoku

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val convertedBoard = convertToListListInt(board)
        if (!checkSquare(convertedBoard)) return false
        if (!checkHorizontal(convertedBoard)) return false
        if (!checkVertical(convertedBoard)) return false
        return true
    }

    private fun convertToListListInt(board: Array<CharArray>): List<List<Int>> {
        return board.map { row ->
            row.map { e ->
                when (e) {
                    '.' -> {
                        0
                    }
                    else -> {
                        e - '0'
                    }
                }
            }
        }
    }

    private fun checkSquare(board: List<List<Int>>): Boolean {
        splitIntoSmallSquareList(board)
            .forEach { smallSquare ->
                val filteredSmallSquare = smallSquare.filter { it != 0 }
                if (filteredSmallSquare.size != filteredSmallSquare.toSet().size) return false
            }
        return true
    }

    private fun splitIntoSmallSquareList(board: List<List<Int>>): List<List<Int>> {
        val targetIdx = listOf(0, 3, 6)
        val result = listOf<MutableList<Int>>(
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        )
        var resultIdx = 0
        targetIdx.forEach { col ->
            targetIdx.forEach { row ->
                board
                    .subList(col, col + 3)
                    .forEach { targetRow ->
                        result[resultIdx].addAll(targetRow.subList(row, row + 3))
                    }
                resultIdx++
            }
        }
        return result
    }

    private fun checkHorizontal(board: List<List<Int>>): Boolean {
        board.forEach { row ->
            val filteredRowList = row.filter { it != 0 }
            if (filteredRowList.size != filteredRowList.toSet().size) return false
        }
        return true
    }

    private fun checkVertical(board: List<List<Int>>): Boolean {
        return checkHorizontal(transpose(board))
    }

    private fun transpose(board: List<List<Int>>): List<List<Int>> {
        val result = listOf<MutableList<Int>>(
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        )
        board.forEach { row ->
            row.forEachIndexed { cIdx, e ->
                result[cIdx].add(e)
            }
        }
        return result
    }
}
