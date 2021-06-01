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

    // TODO Approach 4: Binary search
    // TODO Trie
}
