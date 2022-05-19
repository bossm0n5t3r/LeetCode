package utils

class MatrixUtil {
    fun generateMatrixFrom(raw: String): Array<IntArray> {
        val length = raw.length
        return raw.substring(2, length - 2)
            .split("],[")
            .map {
                it
                    .split(",")
                    .map { str -> str.toInt() }
                    .toIntArray()
            }
            .toTypedArray()
    }
}
