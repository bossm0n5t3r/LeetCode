package findTheDuplicateNumber

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        val seen = BooleanArray(nums.size)
        nums.forEach { num ->
            if (seen[num]) {
                return num
            }
            seen[num] = true
        }
        return -1
    }
}
