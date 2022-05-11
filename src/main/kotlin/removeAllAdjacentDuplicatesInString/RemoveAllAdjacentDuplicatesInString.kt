package removeAllAdjacentDuplicatesInString

import java.util.Stack

class RemoveAllAdjacentDuplicatesInString {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()
        s.forEach { c ->
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        return stack.joinToString("")
    }

    fun removeDuplicatesUsingTwoPointers(s: String): String {
        val n = s.length
        val res = s.toCharArray()
        var i = 0
        var j = 0
        while (j < n) {
            res[i] = res[j]
            if (i > 0 && res[i - 1] == res[j]) {
                i -= 2
            }
            j++
            i++
        }
        return String(res, 0, i)
    }
}
