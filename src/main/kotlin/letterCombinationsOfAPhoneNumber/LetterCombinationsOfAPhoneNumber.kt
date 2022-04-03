package letterCombinationsOfAPhoneNumber

class LetterCombinationsOfAPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) return emptyList()
        val digitToLetters = mapOf(
            2 to listOf("a", "b", "c"),
            3 to listOf("d", "e", "f"),
            4 to listOf("g", "h", "i"),
            5 to listOf("j", "k", "l"),
            6 to listOf("m", "n", "o"),
            7 to listOf("p", "q", "r", "s"),
            8 to listOf("t", "u", "v"),
            9 to listOf("w", "x", "y", "z"),
        )
        var result = mutableListOf<String>()
        var idx = 0
        while (idx < digits.length) {
            val targetDigit = digits[idx].digitToInt()
            val targetLetters = digitToLetters[targetDigit] ?: continue
            if (result.isEmpty()) {
                result.addAll(targetLetters)
            } else {
                result = result.flatMap { first ->
                    targetLetters.map { last ->
                        "$first$last"
                    }
                } as MutableList<String>
            }
            idx++
        }
        return result
    }
}
