package pascalsTriangle

class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 1) return listOf(listOf(1))
        if (numRows == 2) return listOf(listOf(1), listOf(1, 1))
        val result = mutableListOf(listOf(1), listOf(1, 1))
        for (i in 3..numRows) {
            val before = result.last()
            val next = mutableListOf(1)
            for (index in before.indices) {
                when (index) {
                    before.size - 1 -> next.add(before[index])
                    else -> next.add(before[index] + before[index + 1])
                }
            }
            result.add(next)
        }
        return result
    }
}
