package myCalendar1

import java.util.TreeMap

class MyCalendar1 {
    private val treeMap = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val lower = treeMap.lowerKey(end)
        if (lower == null || treeMap[lower]!! <= start) {
            treeMap[start] = end
            return true
        }
        return false
    }
}
