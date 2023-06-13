package validParentheses

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidParenthesesTest {
    private val validParentheses = ValidParentheses()

    data class ValidParenthesesTestData(
        val s: String,
        val result: Boolean,
    )

    @Test
    fun isValid() {
        val tests = listOf(
            ValidParenthesesTestData("()", true),
            ValidParenthesesTestData("()[]{}", true),
            ValidParenthesesTestData("(]", false),
            ValidParenthesesTestData("([)]", false),
            ValidParenthesesTestData("{[]}", true),
        )
        tests.forEach { test ->
            assertEquals(validParentheses.isValid(test.s), test.result)
        }
    }
}
