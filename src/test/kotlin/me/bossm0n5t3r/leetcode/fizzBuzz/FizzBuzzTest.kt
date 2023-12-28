package me.bossm0n5t3r.leetcode.fizzBuzz

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FizzBuzzTest {
    private val fizzBuzz = FizzBuzz.Solution()

    data class FizzBuzzTestData(
        val n: Int,
        val result: List<String>,
    )

    @Test
    fun fizzBuzz() {
        val tests =
            listOf(
                FizzBuzzTestData(3, listOf("1", "2", "Fizz")),
                FizzBuzzTestData(5, listOf("1", "2", "Fizz", "4", "Buzz")),
                FizzBuzzTestData(
                    15,
                    listOf(
                        "1",
                        "2",
                        "Fizz",
                        "4",
                        "Buzz",
                        "Fizz",
                        "7",
                        "8",
                        "Fizz",
                        "Buzz",
                        "11",
                        "Fizz",
                        "13",
                        "14",
                        "FizzBuzz",
                    ),
                ),
            )
        tests.forEach { test ->
            assertEquals(fizzBuzz.fizzBuzz(test.n), test.result)
        }
    }
}
