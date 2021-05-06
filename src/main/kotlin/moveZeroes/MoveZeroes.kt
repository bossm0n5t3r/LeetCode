package moveZeroes

class MoveZeroes {
    private var tmp: Int = 0

    fun moveZeroes(nums: IntArray) {
        var lastNonZeroIndex = 0
        for (cur in nums.indices) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroIndex++, cur)
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }
}
