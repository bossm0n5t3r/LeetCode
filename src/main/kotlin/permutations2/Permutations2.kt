package permutations2

class Permutations2 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val length = nums.size
        val visited = BooleanArray(length)
        val result = mutableSetOf<List<Int>>()
        val arr = IntArray(length)
        dfs(result, nums, arr, visited, length, 0)
        return result.toList()
    }

    private fun dfs(
        result: MutableSet<List<Int>>,
        nums: IntArray,
        arr: IntArray,
        visited: BooleanArray,
        totalLength: Int,
        cnt: Int
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
