package validAnagram

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.toCharArray().apply { sort() }.contentEquals(t.toCharArray().apply { sort() })
    }
}
