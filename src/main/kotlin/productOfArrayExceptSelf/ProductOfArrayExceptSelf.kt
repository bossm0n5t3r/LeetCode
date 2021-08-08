package productOfArrayExceptSelf

class ProductOfArrayExceptSelf {
    // You must write an algorithm that runs in O(n) time and without using the division operation.
    // O(1) extra space complexity
    fun productExceptSelf(nums: IntArray): IntArray {
        val (numOfZeroes, productOfArrayExceptZeroes) = getNumOfZeroesAndProductOfArrayExceptZeroes(nums)
        return when (numOfZeroes) {
            0 -> {
                val result = IntArray(nums.size)
                nums.forEachIndexed { index, i ->
                    result[index] = (productOfArrayExceptZeroes / i).toInt()
                }
                result
            }
            1 -> {
                val result = IntArray(nums.size)
                for (i in nums.indices) {
                    if (nums[i] == 0) {
                        result[i] = productOfArrayExceptZeroes.toInt()
                        break
                    }
                }
                result
            }
            else -> {
                IntArray(nums.size)
            }
        }
    }

    private fun getNumOfZeroesAndProductOfArrayExceptZeroes(nums: IntArray): Pair<Int, Long> {
        var numOfZeroes = 0
        var productOfArrayExceptZeroes: Long = 1
        nums.forEach { num ->
            when (num) {
                0 -> {
                    numOfZeroes++
                    if (numOfZeroes == 2) {
                        return Pair(numOfZeroes, 0)
                    }
                }
                else -> {
                    productOfArrayExceptZeroes *= num
                }
            }
        }
        return Pair(numOfZeroes, productOfArrayExceptZeroes)
    }
}
