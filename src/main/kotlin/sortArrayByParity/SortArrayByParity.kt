package sortArrayByParity

class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        return (nums.filter { it % 2 == 0 } + nums.filterNot { it % 2 == 0 }).toIntArray()
    }

    fun sortArrayByParityWithSwap(nums: IntArray): IntArray {
        var i = 0
        nums.indices.forEach { j ->
            if (nums[j] % 2 == 0) {
                val tmp = nums[i]
                nums[i++] = nums[j]
                nums[j] = tmp
            }
        }
        return nums
    }
}
