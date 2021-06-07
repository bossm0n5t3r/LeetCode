package longestCommonPrefix

class LongestCommonPrefix {
    fun longestCommonPrefixFirst(strs: Array<String>): String {
        val length = strs.size
        if (length == 1) return strs.first()
        if (length == 2) return commonPrefix(strs.first(), strs.last())
        var commonPrefix = commonPrefix(strs[0], strs[1])
        var index = 2
        while (commonPrefix.isNotEmpty() && index < length) {
            commonPrefix = commonPrefix(commonPrefix, strs[index])
            index++
        }
        return commonPrefix
    }

    private fun commonPrefix(first: String, second: String): String {
        val shortLength = if (first.length <= second.length) first.length else second.length
        for (i in 0 until shortLength) {
            if (first[i] != second[i]) {
                return first.substring(0, i)
            }
        }
        return first.substring(0, shortLength)
    }

    fun longestCommonPrefixSecond(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        for (i in 0 until strs.first().length) {
            val c = strs.first()[i]
            for (j in 1 until strs.size) {
                if (i == strs[j].length || c != strs[j][i]) {
                    return strs.first().substring(0, i)
                }
            }
        }
        return strs.first()
    }

    fun longestCommonPrefixThird(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        return longestCommonPrefixThird(strs, 0, strs.size - 1)
    }

    private fun longestCommonPrefixThird(strs: Array<String>, left: Int, right: Int): String {
        if (left == right) return strs[left]
        val mid = (left + right) / 2
        val leftLongestCommonPrefix = longestCommonPrefixThird(strs, left, mid)
        val rightLongestCommonPrefix = longestCommonPrefixThird(strs, mid + 1, right)
        return commonPrefix(leftLongestCommonPrefix, rightLongestCommonPrefix)
    }

    fun longestCommonPrefixFourth(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val minLen = strs.minOf { it.length }
        var low = 0
        var high = minLen
        while (low <= high) {
            val middle = (low + high) / 2
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }
        return strs[0].substring(0, (low + high) / 2)
    }

    private fun isCommonPrefix(strs: Array<String>, len: Int): Boolean {
        val first = strs[0].substring(0, len)
        for (i in 1 until strs.size) {
            if (!strs[i].startsWith(first)) return false
        }
        return true
    }

    fun longestCommonPrefixTrie(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var result = makeTrie(str = strs[0])
        for (i in 1 until strs.size) {
            if (result == null) return ""
            result = commonTrie(result, strs[i])
        }
        return makeString(result)
    }

    private fun makeTrie(str: String): Trie? {
        if (str.isEmpty()) return null
        val result = Trie(str[0])
        var cur = result
        for (i in 1 until str.length) {
            cur.next = Trie(str[i])
            cur = cur.next!!
        }
        return result
    }

    private fun commonTrie(t: Trie, str: String): Trie? {
        if (str.isEmpty()) return null
        if (t.c != str[0]) return null
        var input: Trie? = t.next
        var index = 0
        val result = Trie(str[index++])
        var cur = result
        while (input != null && index != str.length) {
            if (input.c != str[index]) break
            cur.next = Trie(str[index++])
            cur = cur.next!!
            input = input.next
        }
        return result
    }

    private fun makeString(t: Trie?): String {
        if (t == null) return ""
        val result = mutableListOf<Char>()
        var cur: Trie? = t
        while (cur != null) {
            result.add(cur.c)
            cur = cur.next
        }
        return result.joinToString("")
    }
}

class Trie(var c: Char) {
    var next: Trie? = null
}
