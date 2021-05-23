package validPalindrome

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidPalindromeTest {
    private val validPalindrome = ValidPalindrome()

    data class ValidPalindromeTestData(
        val s: String,
        val result: Boolean
    )

    @Test
    fun isPalindrome() {
        val tests = listOf(
            ValidPalindromeTestData("A man, a plan, a canal: Panama", true),
            ValidPalindromeTestData("race a car", false),
            ValidPalindromeTestData(" ", true),
            ValidPalindromeTestData("0P", false)
        )
        tests.forEach { test ->
            assertEquals(validPalindrome.isPalindrome(test.s), test.result)
        }
    }
}
