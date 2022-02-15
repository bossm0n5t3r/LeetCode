package findTheDuplicateNumber

class FindTheDuplicateNumber {
    fun findDuplicateUsingSet(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        nums.forEach { num ->
            if (set.contains(num)) {
                return num
            }
            set.add(num)
        }
        return -1
    }

    fun findDuplicateUsingArray(nums: IntArray): Int {
        val seen = BooleanArray(nums.size)
        nums.forEach { num ->
            if (seen[num]) {
                return num
            }
            seen[num] = true
        }
        return -1
    }

    fun findDuplicateUsingO1Space(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[slow]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }
        fast = 0
        while (slow != fast) {
            fast = nums[fast]
            slow = nums[slow]
        }
        return slow
    }
}
