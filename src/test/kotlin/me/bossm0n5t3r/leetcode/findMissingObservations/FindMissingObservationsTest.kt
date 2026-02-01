package me.bossm0n5t3r.leetcode.findMissingObservations

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindMissingObservationsTest {
    private val sut = FindMissingObservations.Solution()

    private data class TestData(
        val rolls: IntArray,
        val mean: Int,
        val n: Int,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!rolls.contentEquals(other.rolls)) return false
            if (mean != other.mean) return false
            if (n != other.n) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = rolls.contentHashCode()
            result1 = 31 * result1 + mean
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(3, 2, 4, 3), 4, 2, intArrayOf(6, 6)),
                TestData(intArrayOf(1, 5, 6), 3, 4, intArrayOf(3, 2, 2, 2)),
                TestData(intArrayOf(1, 2, 3, 4), 6, 4, intArrayOf()),
            )

        tests.forEach { test ->
            assertTrue {
                sut.missingRolls(test.rolls, test.mean, test.n).contentEquals(test.result)
            }
        }
    }
}
