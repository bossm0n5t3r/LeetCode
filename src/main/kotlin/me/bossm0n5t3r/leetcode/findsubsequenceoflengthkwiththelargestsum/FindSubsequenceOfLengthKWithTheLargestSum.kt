package me.bossm0n5t3r.leetcode.findsubsequenceoflengthkwiththelargestsum

class FindSubsequenceOfLengthKWithTheLargestSum {
    class Solution {
        fun maxSubsequence(
            nums: IntArray,
            k: Int,
        ): IntArray =
            nums
                .withIndex()
                .sortedWith(compareByDescending<IndexedValue<Int>> { it.value }.thenBy { it.index })
                .take(k)
                .sortedBy { it.index }
                .map { it.value }
                .toIntArray()
    }
}
