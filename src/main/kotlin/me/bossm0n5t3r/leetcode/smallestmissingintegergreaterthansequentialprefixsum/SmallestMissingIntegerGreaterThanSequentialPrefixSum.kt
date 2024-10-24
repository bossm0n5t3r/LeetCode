package me.bossm0n5t3r.leetcode.smallestmissingintegergreaterthansequentialprefixsum

class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    class Solution {
        fun missingInteger(nums: IntArray): Int {
            var tmpIndex = 0
            var longestPrefixSum = nums[tmpIndex]
            while (tmpIndex + 1 < nums.size && nums[tmpIndex] + 1 == nums[tmpIndex + 1]) {
                tmpIndex++
                longestPrefixSum += nums[tmpIndex]
            }
            val numsSet = nums.toSet()
            while (numsSet.contains(longestPrefixSum)) {
                longestPrefixSum++
            }
            return longestPrefixSum
        }
    }
}
