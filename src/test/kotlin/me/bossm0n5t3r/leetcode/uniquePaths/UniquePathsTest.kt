package me.bossm0n5t3r.leetcode.uniquePaths

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UniquePathsTest {
    private val uniquePaths = UniquePaths.Solution()

    data class UniquePathsTestData(
        val m: Int,
        val n: Int,
        val result: Int,
    )

    @Test
    fun uniquePaths() {
        val tests =
            listOf(
                UniquePathsTestData(3, 7, 28),
                UniquePathsTestData(3, 2, 3),
                UniquePathsTestData(16, 16, 155117520),
            )
        tests.forEach { test ->
            assertEquals(uniquePaths.uniquePaths(test.m, test.n), test.result)
            assertEquals(uniquePaths.uniquePathsUsingDP(test.m, test.n), test.result)
        }
    }
}
