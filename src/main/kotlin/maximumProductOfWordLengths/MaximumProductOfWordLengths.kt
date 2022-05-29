package maximumProductOfWordLengths

class MaximumProductOfWordLengths {
    fun maxProduct(words: Array<String>): Int {
        var result = 0
        var left: String
        var right: String
        (0 until words.size - 1).forEach { i ->
            (i + 1 until words.size).forEach { j ->
                if (words[i] != words[j] &&
                    words[i].toSet().intersect(words[j].toSet()).isEmpty() &&
                    words[i].length * words[j].length > result
                ) {
                    left = words[i]
                    right = words[j]
                    result = left.length * right.length
                }
            }
        }
        return result
    }
}
