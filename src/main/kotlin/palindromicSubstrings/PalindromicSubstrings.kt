package palindromicSubstrings

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var result = 0
        val n = s.length
        (0 until n).forEach { i ->
            (i until n).forEach { j ->
                if (isPalindrome(s.substring(i, j + 1))) result++
            }
        }
        return result
    }

    fun isPalindrome(s: String): Boolean {
        val n = s.length
        (0..(n / 2)).forEach { i ->
            if (s[i] != s[n - 1 - i]) return false
        }
        return true
    }
}
