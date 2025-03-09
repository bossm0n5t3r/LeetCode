package me.bossm0n5t3r.leetcode.minimumrecolorstogetkconsecutiveblackblocks

class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    class Solution {
        fun minimumRecolors(
            blocks: String,
            k: Int,
        ): Int {
            val prefixSum = blocks.runningFold(0) { acc: Int, c: Char -> if (c == 'W') acc + 1 else acc }.drop(1)
            var result = prefixSum.last()
            for (i in blocks.lastIndex downTo k) {
                if (result > prefixSum[i] - prefixSum[i - k]) {
                    result = prefixSum[i] - prefixSum[i - k]
                }
            }
            result = minOf(result, prefixSum[k - 1])
            return result
        }
    }
}
