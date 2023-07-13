package me.bossm0n5t3r.leetcode.uniqueNumberOfOccurrences

class UniqueNumberOfOccurrences {
    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val map = mutableMapOf<Int, Int>()
            for (num in arr) {
                map[num] = map.getOrDefault(num, 0) + 1
            }
            val values = map.values
            return values.size == values.toSet().size
        }
    }
}
