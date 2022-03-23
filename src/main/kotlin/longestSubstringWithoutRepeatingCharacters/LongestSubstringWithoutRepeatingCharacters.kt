package longestSubstringWithoutRepeatingCharacters

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == s.toSet().size) return s.length
        var result = -1
        var start = 0
        var end = 0
        while (start < s.length) {
            while (end <= s.length && s.substring(start, end).length == s.substring(start, end).toSet().size) {
                end++
            }
            if (end - start - 1 > result) {
                result = end - start - 1
            }
            start++
        }
        return result
    }
}
