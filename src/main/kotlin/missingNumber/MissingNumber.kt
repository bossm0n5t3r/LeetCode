package missingNumber

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        var result = n * (n + 1) / 2
        for (num in nums) {
            result -= num
        }
        return result
    }
}
