package shortestUnsortedContinuousSubarray

class ShortestUnsortedContinuousSubarray {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var s = 0
        while (s + 1 < nums.size && nums[s] <= nums[s + 1]) {
            s++
        }
        var e = nums.size - 1
        while (e - 1 >= 0 && nums[e] >= nums[e - 1]) {
            e--
        }
        if (s >= e) return 0
        val tmpSubarray = nums.toList().subList(s, e + 1)
        val min = tmpSubarray.minOrNull()!!
        val max = tmpSubarray.maxOrNull()!!
        while (s - 1 >= 0 && nums[s - 1] > min) {
            s--
        }
        while (e + 1 < nums.size && nums[e + 1] < max) {
            e++
        }
        return (e - s + 1)
    }
}
