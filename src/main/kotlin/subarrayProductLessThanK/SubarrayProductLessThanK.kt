package subarrayProductLessThanK

import java.util.LinkedList
import java.util.Queue

class SubarrayProductLessThanK {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var result = 0
        var keepGoing = true
        var intArraySize = 1
        var q: Queue<IntArray> = makeSubarrayQueue(nums, intArraySize)
        while (keepGoing) {
            val size = q.size
            (1..size).forEach { _ ->
                val curIntArray = q.poll()
                val subarrayProduct = getSubarrayProduct(curIntArray)
                if (subarrayProduct < k) {
                    result++
                } else if (keepGoing) {
                    keepGoing = false
                }
            }
            intArraySize++
            if (keepGoing) q = makeSubarrayQueue(nums, intArraySize)
        }
        return result
    }

    private fun makeSubarrayQueue(nums: IntArray, intArraySize: Int): LinkedList<IntArray> {
        val result = LinkedList<IntArray>()
        if (intArraySize > nums.size) return result
        for (i in 0 until (nums.size - intArraySize + 1)) {
            result.add(nums.sliceArray(i until i + intArraySize))
        }
        return result
    }

    private fun getSubarrayProduct(nums: IntArray): Int {
        var product = 1
        nums.forEach { product *= it }
        return product
    }
}
