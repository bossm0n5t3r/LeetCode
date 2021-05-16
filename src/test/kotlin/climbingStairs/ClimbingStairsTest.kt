package climbingStairs

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ClimbingStairsTest {
    private val climbingStairs = ClimbingStairs()

    data class ClimbingStairsTestData(
        val n: Int,
        val result: Int
    )

    @Test
    fun climbStairs() {
        val tests = listOf(
            ClimbingStairsTestData(2, 2),
            ClimbingStairsTestData(3, 3)
        )

        tests.forEach { test ->
            assertEquals(climbingStairs.climbStairs(test.n), test.result)
        }
    }
}
