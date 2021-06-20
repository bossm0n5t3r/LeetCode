package generateParentheses

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenerateParenthesesTest {
    private val generateParentheses = GenerateParentheses()

    data class GenerateParenthesesTestData(
        val n: Int,
        val result: List<String>
    )

    @Test
    fun generateParenthesis() {
        val tests = listOf(
            GenerateParenthesesTestData(3, listOf("((()))", "(()())", "(())()", "()(())", "()()()")),
            GenerateParenthesesTestData(1, listOf("()"))
        )
        tests.forEach { test ->
            assertEquals(generateParentheses.generateParenthesis(test.n), test.result)
        }
    }
}
