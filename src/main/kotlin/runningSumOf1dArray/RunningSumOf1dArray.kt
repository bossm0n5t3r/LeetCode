package runningSumOf1dArray

class RunningSumOf1dArray {
    fun runningSum(nums: IntArray): IntArray {
        var before = 0
        nums.forEachIndexed { index, i ->
            val tmp = before + i
            nums[index] = tmp
            before = tmp
        }
        return nums
    }
}
