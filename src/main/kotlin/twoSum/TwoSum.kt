package twoSum

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size == 2) return intArrayOf(0, 1)
        val length = nums.size
        for (i in 0 until length - 1) {
            for (j in i + 1 until length) {
                if (nums[i] + nums[j] == target) return intArrayOf(i, j)
            }
        }
        return intArrayOf()
    }
}
