package triangle

import kotlin.math.min

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val cache = triangle.map { it.toMutableList() }
        cache.first()[0] = triangle.first().first()
        (1 until n).forEach { i ->
            (0..i).forEach { j ->
                when (j) {
                    0 -> {
                        cache[i][j] = cache[i - 1][j] + triangle[i][j]
                    }
                    i -> {
                        cache[i][j] = cache[i - 1][j - 1] + triangle[i][j]
                    }
                    else -> {
                        cache[i][j] = min(cache[i - 1][j - 1], cache[i - 1][j]) + triangle[i][j]
                    }
                }
            }
        }
        return cache.last().minOrNull() ?: -1
    }
}
