package containsDuplicate2

class ContainsDuplicate2 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0) return false
        if (nums.size == 1) return false
        val n = nums.size
        var s = 0
        var e = 1
        while (e < n) {
            while (e - s <= k && e < n) {
                if (nums[s] == nums[e]) return true
                e++
            }
            s++
            e = s + 1
        }
        return false
    }
}
