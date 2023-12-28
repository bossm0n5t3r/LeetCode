package me.bossm0n5t3r.leetcode.dominoAndTrominoTiling

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DominoAndTrominoTilingTest {
    private val sut = DominoAndTrominoTiling.Solution()

    private data class TestData(
        val n: Int,
        val result: Int,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(3, 5),
                TestData(1, 1),
                TestData(4, 11),
            )

        tests.forEach { test ->
            assertEquals(
                sut.numTilings(test.n),
                test.result,
            )
        }
    }
}
