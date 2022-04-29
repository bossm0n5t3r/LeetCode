package smallestStringWithSwaps

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SmallestStringWithSwapsTest {
    private val smallestStringWithSwaps = SmallestStringWithSwaps()

    private data class SmallestStringWithSwapsTestData(
        val s: String,
        val pairs: List<List<Int>>,
        val result: String
    )

    @Test
    fun smallestStringWithSwaps() {
        val tests = listOf(
            SmallestStringWithSwapsTestData("dcab", listOf(listOf(0, 3), listOf(1, 2)), "bacd"),
            SmallestStringWithSwapsTestData("dcab", listOf(listOf(0, 3), listOf(1, 2), listOf(0, 2)), "abcd"),
            SmallestStringWithSwapsTestData("cba", listOf(listOf(0, 1), listOf(1, 2)), "abc"),
        )
        tests.forEach { test ->
            val result = smallestStringWithSwaps.smallestStringWithSwaps(test.s, test.pairs)
            println(result)
            assertEquals(result, test.result)
        }
    }
}
