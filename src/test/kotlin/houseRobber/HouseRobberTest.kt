package houseRobber

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HouseRobberTest {
    private val houseRobber = HouseRobber()

    data class HouseRobberTestData(
        val nums: IntArray,
        val result: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as HouseRobberTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun rob() {
        val tests = listOf(
            HouseRobberTestData(intArrayOf(1, 2, 3, 1), 4),
            HouseRobberTestData(intArrayOf(2, 7, 9, 3, 1), 12)
        )
        tests.forEach { test ->
            assertEquals(houseRobber.rob(test.nums), test.result)
        }
    }
}
