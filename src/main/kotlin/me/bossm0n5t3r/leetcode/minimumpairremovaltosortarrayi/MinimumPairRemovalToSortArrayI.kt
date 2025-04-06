package me.bossm0n5t3r.leetcode.minimumpairremovaltosortarrayi

class MinimumPairRemovalToSortArrayI {
    class Solution {
        fun minimumPairRemoval(nums: IntArray): Int {
            val numList = nums.toMutableList()
            var operations = 0
            while (numList.isNonDecreasing().not()) {
                numList.doOperation()
                operations++
            }
            return operations
        }

        private fun List<Int>.isNonDecreasing(): Boolean {
            for (i in 1 until size) {
                if (this[i] < this[i - 1]) {
                    return false
                }
            }
            return true
        }

        private fun MutableList<Int>.doOperation() {
            var index = 0
            var sum = this[0] + this[1]
            for (i in 1 until size - 1) {
                val currentSum = this[i] + this[i + 1]
                if (currentSum < sum) {
                    sum = currentSum
                    index = i
                }
            }
            this[index] = sum
            this.removeAt(index + 1)
        }
    }
}
