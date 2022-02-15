package findTheDuplicateNumber

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        nums.forEach { num ->
            if (set.contains(num)) {
                return num
            }
            set.add(num)
        }
        return -1
    }
}
