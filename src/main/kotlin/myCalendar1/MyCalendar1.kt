package myCalendar1

import java.util.TreeMap

class MyCalendar1 {
    private val treeMap = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        if (treeMap.containsKey(start)) return false
        val upperStartKey = try {
            treeMap.ceilingKey(start) ?: Int.MAX_VALUE
        } catch (e: Exception) {
            Int.MAX_VALUE
        }
        val lowerEnd = try {
            val lowerStartKey = treeMap.floorKey(start)
            treeMap[lowerStartKey] ?: Int.MIN_VALUE
        } catch (e: Exception) {
            Int.MIN_VALUE
        }
        if (start < lowerEnd || upperStartKey < end) return false
        treeMap[start] = end
        return true
    }
}
