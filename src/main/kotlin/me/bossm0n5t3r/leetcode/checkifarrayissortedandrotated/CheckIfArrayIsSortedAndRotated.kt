package me.bossm0n5t3r.leetcode.checkifarrayissortedandrotated

class CheckIfArrayIsSortedAndRotated {
    class Solution {
        fun check(nums: IntArray): Boolean {
            var count = 0
            for (i in nums.indices) {
                if (nums[i] > nums[(i + 1) % nums.size]) {
                    count++
                }
            }
            return count <= 1
        }
    }
}
