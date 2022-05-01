package minimumNumberOfStepsToMakeTwoStringsAnagram2

import kotlin.math.absoluteValue

class MinimumNumberOfStepsToMakeTwoStringsAnagram2 {
    fun minSteps(s: String, t: String): Int {
        val count = IntArray(26) { 0 }
        s.forEach { c -> count[c - 'a']++ }
        t.forEach { c -> count[c - 'a']-- }
        return count.sumOf { it.absoluteValue }
    }
}
