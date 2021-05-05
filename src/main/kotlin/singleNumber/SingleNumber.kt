package singleNumber

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        for (i in 1 until nums.size) {
            nums[0] = nums[0].xor(nums[i])
        }
        return nums[0]
    }
}
