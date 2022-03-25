package longestPalindromicSubstring

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length <= 1) return s
        var result = ""
        (s.indices).forEach { i ->
            if (s[i].toString().length > result.length) {
                result = s[i].toString()
            }
            if (i + 1 < s.length && s[i] == s[i + 1]) {
                var start = i
                var end = i + 1
                while (start >= 1 && end + 1 < s.length && s[start - 1] == s[end + 1]) {
                    start--
                    end++
                }
                if (end - start + 1 > result.length) {
                    result = s.substring(start, end + 1)
                }
            }
            if (i >= 1 && i + 1 < s.length && s[i - 1] == s[i + 1]) {
                var start = i - 1
                var end = i + 1
                while (start >= 1 && end + 1 < s.length && s[start - 1] == s[end + 1]) {
                    start--
                    end++
                }
                if (end - start + 1 > result.length) {
                    result = s.substring(start, end + 1)
                }
            }
        }
        return result
    }
}
