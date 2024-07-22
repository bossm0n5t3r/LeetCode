package me.bossm0n5t3r.leetcode.sortThePeople

class SortThePeople {
    class Solution {
        fun sortPeople(
            names: Array<String>,
            heights: IntArray,
        ): Array<String> {
            return names.zip(heights.toTypedArray())
                .sortedByDescending { it.second }
                .map { it.first }
                .toTypedArray()
        }
    }
}
