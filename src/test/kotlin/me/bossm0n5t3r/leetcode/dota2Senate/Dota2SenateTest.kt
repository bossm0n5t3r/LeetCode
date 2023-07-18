package me.bossm0n5t3r.leetcode.dota2Senate

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Dota2SenateTest {
    private val sut = Dota2Senate.Solution()
    
    private data class TestData(
        val senate: String,
        val result: String,
    )
    
    @Test
    fun test() {
        val tests = listOf(
            TestData(
                "RD",
                "Radiant",
            ),
            TestData(
                "RDD",
                "Dire",
            ),
        )
        
        tests.forEach { test ->
            assertEquals(
                sut.predictPartyVictory(test.senate),
                test.result,
            )
        }
    }
}
