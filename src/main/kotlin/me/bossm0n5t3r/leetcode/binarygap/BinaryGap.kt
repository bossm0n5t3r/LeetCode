package me.bossm0n5t3r.leetcode.binarygap

class BinaryGap {
    class Solution {
        fun binaryGap(n: Int): Int {
            var num = n
            var maxGap = 0
            var lastPos = -1
            var currentPos = 0
            while (num > 0) {
                if ((num and 1) == 1) {
                    if (lastPos != -1) {
                        maxGap = maxOf(maxGap, currentPos - lastPos)
                    }
                    lastPos = currentPos
                }
                num = num shr 1
                currentPos++
            }
            return maxGap
        }
    }
}
