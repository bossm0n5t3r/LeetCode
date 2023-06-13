package longestCommonPrefix

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestCommonPrefixTest {
    private val longestCommonPrefix = LongestCommonPrefix()

    data class LongestCommonPrefixTestData(
        val strs: Array<String>,
        val result: String,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as LongestCommonPrefixTestData

            if (!strs.contentEquals(other.strs)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = strs.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun longestCommonPrefix() {
        val tests = listOf(
            LongestCommonPrefixTestData(arrayOf("flower", "flow", "flight"), "fl"),
            LongestCommonPrefixTestData(arrayOf("dog", "racecar", "car"), ""),
            LongestCommonPrefixTestData(arrayOf(""), ""),
            LongestCommonPrefixTestData(arrayOf("abab", "aba", ""), ""),
        )
        tests.forEach { test ->
            assertEquals(longestCommonPrefix.longestCommonPrefixFirst(test.strs), test.result)
            assertEquals(longestCommonPrefix.longestCommonPrefixSecond(test.strs), test.result)
            assertEquals(longestCommonPrefix.longestCommonPrefixThird(test.strs), test.result)
            assertEquals(longestCommonPrefix.longestCommonPrefixFourth(test.strs), test.result)
            assertEquals(longestCommonPrefix.longestCommonPrefixTrie(test.strs), test.result)
        }
    }
}
