package subarrayProductLessThanK

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SubarrayProductLessThanKTest {
    private val subarrayProductLessThanK = SubarrayProductLessThanK()

    data class SubarrayProductLessThanKTestData(
        val nums: IntArray,
        val k: Int,
        val result: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SubarrayProductLessThanKTestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    @Disabled
    fun numSubarrayProductLessThanK() {
        val tests = listOf(
            SubarrayProductLessThanKTestData(intArrayOf(10, 5, 2, 6), 100, 8)
        )
        tests.forEach { test ->
            println(subarrayProductLessThanK.numSubarrayProductLessThanK(test.nums, test.k))
            assertEquals(subarrayProductLessThanK.numSubarrayProductLessThanK(test.nums, test.k), test.result)
        }
    }
}
