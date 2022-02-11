package validPalindrome

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val simpleAlphanumericCharList = makeAlphanumericCharList(s)
        if (simpleAlphanumericCharList.isEmpty()) return true
        val length = simpleAlphanumericCharList.size
        (0..length / 2).forEach {
            if (simpleAlphanumericCharList[it] != simpleAlphanumericCharList[length - it - 1]) return false
        }
        return true
    }

    private fun makeAlphanumericCharList(s: String): List<Char> {
        val result = mutableListOf<Char>()
        s.forEach { c ->
            when (c) {
                in 'a'..'z' -> {
                    result.add(c)
                }
                in 'A'..'Z' -> {
                    result.add(c.lowercaseChar())
                }
                in '0'..'9' -> {
                    result.add(c)
                }
                else -> {
                }
            }
        }
        return result
    }
}
