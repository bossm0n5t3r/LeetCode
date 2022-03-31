package threeSumClosest

import kotlin.math.abs

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val seen = mutableSetOf<Int>()
        var result = 13001
        val size = nums.size
        (0 until size - 2).forEach { i ->
            (i + 1 until size - 1).forEach { j ->
                (j + 1 until size).forEach { k ->
                    val tmp = nums[i] + nums[j] + nums[k]
                    if (!seen.contains(tmp)) {
                        seen.add(tmp)
                        if (abs(tmp - target) < abs(result - target)) {
                            result = tmp
                        }
                    }
                }
            }
        }
        return result
    }
}
