package me.bossm0n5t3r.leetcode.minimumnumberofoperationstomoveallballstoeachbox

class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    class Solution {
        fun minOperations(boxes: String): IntArray {
            val n = boxes.length
            val result = IntArray(n)
            val left2Right = IntArray(n)
            val right2Left = IntArray(n)

            var left2RightCount = if (boxes[0] == '1') 1 else 0
            for (i in 1 until n) {
                left2Right[i] = left2Right[i - 1] + left2RightCount
                result[i] += left2Right[i]
                left2RightCount += if (boxes[i] == '1') 1 else 0
            }

            var right2LeftCount = if (boxes[n - 1] == '1') 1 else 0
            for (i in n - 2 downTo 0) {
                right2Left[i] = right2Left[i + 1] + right2LeftCount
                result[i] += right2Left[i]
                right2LeftCount += if (boxes[i] == '1') 1 else 0
            }

            return result
        }
    }
}
