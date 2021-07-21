package rotateImage

class RotateImage {
    fun rotateMyFirstSolution(matrix: Array<IntArray>) {
        if (matrix.size == 1) return
        val n = matrix.size
        val depth = n / 2
        (1..depth).forEach { r ->
            (r - 1 until n - r).forEach { c ->
                rotateAt(Pair(r - 1, c), matrix, n)
            }
        }
    }

    private fun rotateAt(start: Pair<Int, Int>, matrix: Array<IntArray>, n: Int) {
        var beforeValue = matrix[start.first][start.second]
        var cur = start
        do {
            val next = Pair(cur.second, n - 1 - cur.first)
            val nextValue = matrix[next.first][next.second]
            matrix[next.first][next.second] = beforeValue
            cur = next
            if (cur != start) {
                beforeValue = nextValue
            }
        } while (cur != start)
        matrix[start.first][start.second] = beforeValue
    }
}
