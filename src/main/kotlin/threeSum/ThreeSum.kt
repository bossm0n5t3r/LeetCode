package threeSum

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val sortedNums = nums.sorted()
        val result = mutableListOf<List<Int>>()
        for (i in 0 until nums.size - 2) {
            if (i == 0 || sortedNums[i] != sortedNums[i - 1]) {
                var low = i + 1
                var high = nums.size - 1
                val sum = 0 - sortedNums[i]
                while (low < high) {
                    if (sortedNums[low] + sortedNums[high] == sum) {
                        result.add(listOf(sortedNums[i], sortedNums[low], sortedNums[high]))
                        while (low < high && sortedNums[low] == sortedNums[low + 1]) {
                            low++
                        }
                        while (low < high && sortedNums[high] == sortedNums[high - 1]) {
                            high--
                        }
                        low++
                        high--
                    } else if (sortedNums[low] + sortedNums[high] < sum) {
                        low++
                    } else if (sortedNums[low] + sortedNums[high] > sum) {
                        high--
                    }
                }
            }
        }
        return result
    }
}
