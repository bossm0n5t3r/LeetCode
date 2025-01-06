package me.bossm0n5t3r.leetcode.minimumnumberofoperationstomoveallballstoeachbox

class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    class Solution {
        fun minOperations(boxes: String): IntArray {
            val result = IntArray(boxes.length)
            for (i in boxes.indices) {
                val box = boxes[i]
                if (box == '1') {
                    for (j in boxes.indices) {
                        if (j != i) {
                            result[j] += (j - i).abs()
                        }
                    }
                }
            }
            return result
        }

        private fun Int.abs() = if (this >= 0) this else -this
    }
}
