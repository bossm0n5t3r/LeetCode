package me.bossm0n5t3r.leetcode.subsets

class Subsets {
    class Solution {
        fun subsets(nums: IntArray): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val target = mutableListOf<Int>()
            dfs(result, target, nums, 0)
            return result
        }

        private fun dfs(result: MutableList<List<Int>>, target: MutableList<Int>, nums: IntArray, index: Int) {
            if (index == nums.size) {
                result.add(target)
                return
            }
            dfs(result, target.toMutableList(), nums, index + 1)
            target.add(nums[index])
            dfs(result, target.toMutableList(), nums, index + 1)
        }
    }
}
