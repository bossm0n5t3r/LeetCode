package reverseString

import org.junit.jupiter.api.Test

class SolutionTest {
    private val solution = Solution()

    @Test
    fun reverseString() {
        val input = listOf(
            "hello".toCharArray(),
            "Hannah".toCharArray(),
            "A man, a plan, a canal: Panama".toCharArray()
        )
        val result = listOf(
            "olleh".toCharArray(),
            "hannaH".toCharArray(),
            "amanaP :lanac a ,nalp a ,nam A".toCharArray()
        )
        input.forEachIndexed { index, s ->
            println(solution.reverseString(s).contentEquals(result[index]))
        }
    }
}
