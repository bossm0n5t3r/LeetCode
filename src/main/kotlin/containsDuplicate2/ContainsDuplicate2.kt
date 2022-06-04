package containsDuplicate2

import kotlin.math.abs

class ContainsDuplicate2 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val n = nums.size
        val recent = mutableMapOf<Int, Int>()
        (0 until n).forEach { i ->
            if (recent.contains(nums[i]) && abs(recent[nums[i]]!! - i) <= k) return true
            recent[nums[i]] = i
        }
        return false
    }
}
