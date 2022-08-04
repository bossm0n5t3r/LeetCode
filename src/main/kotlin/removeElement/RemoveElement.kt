package removeElement

class RemoveElement {
    fun removeElement(nums: IntArray, target: Int): Int {
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
