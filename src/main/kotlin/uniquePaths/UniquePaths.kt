package uniquePaths

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val min = min(m - 1, n - 1)
        val sum = m + n - 2
        var result = 1L
        for (i in 0 until min) {
            result *= (sum - i)
            result /= (i + 1)
        }
        return result.toInt()
    }

    private fun min(m: Int, n: Int): Int {
        return if (m < n) m else n
    }
}
