package majorityElement

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var result: Int? = null
        for (num in nums) {
            if (count == 0) result = num
            count += if (result == num) 1 else -1
        }
        return result!!
    }
}
