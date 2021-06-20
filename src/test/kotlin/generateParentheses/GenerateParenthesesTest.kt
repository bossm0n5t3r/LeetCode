package generateParentheses

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
            val resultBruteForce = generateParentheses.generateParenthesisBruteForce(test.n)
            assertTrue(resultBruteForce.containsAll(test.result))
            assertEquals(resultBruteForce.size, test.result.size)

            val resultBacktracking = generateParentheses.generateParenthesisBacktracking(test.n)
            assertTrue(resultBacktracking.containsAll(test.result))
            assertEquals(resultBacktracking.size, test.result.size)

            val resultClosureNumber = generateParentheses.generateParenthesisClosureNumber(test.n)
            assertTrue(resultClosureNumber.containsAll(test.result))
            assertEquals(resultClosureNumber.size, test.result.size)
        }
    }
}
