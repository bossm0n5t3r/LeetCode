package generateParentheses

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val arr = CharArray(n * 2)
        generateAllParentheses(result, arr, 0)
        return result
    }

    private fun generateAllParentheses(result: MutableList<String>, arr: CharArray, pos: Int) {
        if (pos == arr.size) {
            val parenthesis = arr.joinToString("")
            if (isValidParenthesis(parenthesis)) {
                result.add(parenthesis)
            }
            return
        }
        arr[pos] = '('
        generateAllParentheses(result, arr, pos + 1)
        arr[pos] = ')'
        generateAllParentheses(result, arr, pos + 1)
    }

    private fun isValidParenthesis(parenthesis: String): Boolean {
        var balance = 0
        parenthesis.forEach { c ->
            if (c == '(') {
                balance++
            } else {
                balance--
            }
            if (balance < 0) return false
        }
        return balance == 0
    }
}
