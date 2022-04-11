package shift2DGrid

class Shift2DGrid {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid.first().size
        return grid
            .flatMap { it.toList() }
            .let { it.takeLast(k % (m * n)) + it.dropLast(k % (m * n)) }
            .chunked(n)
    }
}
