package longestPalindromicSubstring

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class LongestPalindromicSubstringTest {
    private val longestPalindromicSubstring = LongestPalindromicSubstring()

    private data class LongestPalindromicSubstringTestData(
        val s: String,
        val result: String
    )

    @Test
    fun longestPalindrome() {
        val tests = listOf(
            LongestPalindromicSubstringTestData(
                "babad",
                "bab"
            ),
            LongestPalindromicSubstringTestData(
                "cbbd",
                "bb"
            ),
            LongestPalindromicSubstringTestData(
                "a",
                "a"
            ),
            LongestPalindromicSubstringTestData(
                "ac",
                "a"
            ),
            LongestPalindromicSubstringTestData(
                "ccc",
                "ccc"
            ),
            LongestPalindromicSubstringTestData(
                "aaaa",
                "aaaa"
            )
        )
        tests.forEach { test ->
            println(longestPalindromicSubstring.longestPalindrome(test.s))
            assertEquals(longestPalindromicSubstring.longestPalindrome(test.s), test.result)
        }
    }
}
