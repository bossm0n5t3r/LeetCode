package me.bossm0n5t3r.leetcode.permutations

class Permutations {
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            val length = nums.size
            val visited = BooleanArray(length)
            val result = mutableListOf<List<Int>>()
            val arr = IntArray(length)
            dfs(result, nums, arr, visited, length, 0)
            return result
        }

        private fun dfs(
            result: MutableList<List<Int>>,
            nums: IntArray,
            arr: IntArray,
            visited: BooleanArray,
            totalLength: Int,
            cnt: Int,
        ) {
            if (cnt == totalLength) {
                result.add(arr.toList())
                return
            }
            for (i in 0 until totalLength) {
                if (!visited[i]) {
                    visited[i] = true
                    arr[cnt] = nums[i]
                    dfs(result, nums, arr, visited, totalLength, cnt + 1)
                    visited[i] = false
                }
            }
        }
    }
}
