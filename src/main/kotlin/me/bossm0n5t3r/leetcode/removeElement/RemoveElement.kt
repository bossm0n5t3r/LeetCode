package me.bossm0n5t3r.leetcode.removeElement

class RemoveElement {
    class Solution {
        fun removeElement(
            nums: IntArray,
            target: Int,
        ): Int {
            var count = 0
            var idx = 0
            nums.indices.forEach { i ->
                if (nums[i] != target) {
                    nums[idx++] = nums[i]
                } else {
                    count++
                }
            }
            return nums.size - count
        }
    }
}
