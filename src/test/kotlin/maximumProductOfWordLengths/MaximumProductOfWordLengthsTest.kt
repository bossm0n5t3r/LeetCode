package maximumProductOfWordLengths

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MaximumProductOfWordLengthsTest {
    private val maximumProductOfWordLengths = MaximumProductOfWordLengths()

    private data class MaximumProductOfWordLengthsTestData(
        val words: Array<String>,
        val result: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MaximumProductOfWordLengthsTestData

            if (!words.contentEquals(other.words)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun maxProduct() {
        val tests = listOf(
            MaximumProductOfWordLengthsTestData(
                arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef"),
                16
            ),
            MaximumProductOfWordLengthsTestData(
                arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd"),
                4
            ),
        )
        tests.forEach { test ->
            maximumProductOfWordLengths.maxProduct(test.words)
                .also {
                    println(it)
                    assertEquals(it, test.result)
                }
        }
    }
}
