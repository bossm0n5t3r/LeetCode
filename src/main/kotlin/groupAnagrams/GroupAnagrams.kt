package groupAnagrams

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { makeKey(it) }.values.toList()
    }

    private fun makeKey(str: String): String {
        var result = ""
        str.toSortedSet().associateWith { str.count { c -> c == it } }.forEach { (char, count) ->
            result += "$char$count"
        }
        return result
    }
}
