package moveZeroes

class MoveZeroes {
    fun moveZeroes(nums: IntArray) {
        var lastNonZeroIndex = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i]
            }
        }
        for (i in lastNonZeroIndex until nums.size) {
            nums[i] = 0
        }
    }
}
