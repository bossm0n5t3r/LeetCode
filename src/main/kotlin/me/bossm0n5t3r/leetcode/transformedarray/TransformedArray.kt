package me.bossm0n5t3r.leetcode.transformedarray

class TransformedArray {
    class Solution {
        fun constructTransformedArray(nums: IntArray): IntArray {
            val n = nums.size
            val result = IntArray(n)
            for (i in 0 until n) {
                val num = nums[i]
                result[i] =
                    when {
                        num > 0 -> nums[(i + num) % n]
                        num < 0 -> {
                            val absNum = num.abs()
                            nums[(n * (absNum / n + 1) + i - absNum) % n]
                        }

                        else -> 0
                    }
            }
            return result
        }

        private fun Int.abs() = if (this >= 0) this else -this
    }
}
