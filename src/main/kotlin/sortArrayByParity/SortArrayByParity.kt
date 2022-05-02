package sortArrayByParity

class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        return (nums.filter { it % 2 == 0 } + nums.filterNot { it % 2 == 0 }).toIntArray()
    }
}
