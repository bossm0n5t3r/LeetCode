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
        var lastIdx = digits.length - 1
        digitToLetters[digits[lastIdx].digitToInt()]?.let { result.addAll(it) }
        lastIdx--
        while (lastIdx >= 0) {
            val tmp = mutableListOf<String>()
            val target = digits[lastIdx].digitToInt()
            digitToLetters[target]?.forEach { first ->
                result.forEach { last ->
                    tmp.add("$first$last")
                }
            }
            result = tmp
            lastIdx--
        }
        return result
    }
}
