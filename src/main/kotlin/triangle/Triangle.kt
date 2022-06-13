package triangle

import kotlin.math.min

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val cache = IntArray(n) { 0 }
        cache[0] = triangle.first().first()
        (1 until n).forEach { i ->
            (i downTo 0).forEach { j ->
                cache[j] = when (j) {
                    i -> {
                        cache[j - 1]
                    }
                    0 -> {
                        cache[j]
                    }
                    else -> {
                        min(cache[j - 1], cache[j])
                    }
                } + triangle[i][j]
            }
        }
        return cache.minOrNull() ?: -1
    }
}
