package me.bossm0n5t3r.leetcode.removeDuplicatesFromSortedArrayII

class RemoveDuplicatesFromSortedArrayII {
    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            var index = 0
            for (num in nums) {
                if (index == 0 || index == 1 || nums[index - 2] != num) {
                    nums[index++] = num
                }
            }
            return index
        }
    }
}
