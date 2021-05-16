package maximumSubarray

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var globalMax = Int.MIN_VALUE
        var localMax = 0
        nums.forEach {
            localMax = if (it + localMax >= it) it + localMax else it
            if (localMax > globalMax) {
                globalMax = localMax
            }
        }
        return globalMax
    }
}
