package maximumErasureValue

class MaximumErasureValue {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var result = 0
        var start = 0
        val cache = mutableMapOf<Int, Int>()
        val partialSum = IntArray(nums.size) { 0 }
        nums.forEachIndexed { end, num ->
            partialSum[end] = partialSum.getOrElse(end - 1) { 0 } + num
            if (cache.containsKey(num)) {
                val previousIdx = cache[num]!!
                while (start <= previousIdx) {
                    start++
                }
            }
            result = result.coerceAtLeast(partialSum[end] - partialSum.getOrElse(start - 1) { 0 })
            cache[num] = end
        }
        return result
    }
}
