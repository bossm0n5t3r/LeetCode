package removeDuplicatesFromSortedArray

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty() || nums.size == 1) return nums.size
        var lastIndex = 0
        for (i in 1 until nums.size) {
            if (nums[i] > nums[lastIndex]) {
                nums[++lastIndex] = nums[i]
            }
        }
        return lastIndex + 1
    }
}
