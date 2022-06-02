package beautifulArrangement2

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class BeautifulArrangement2Test {
    private val beautifulArrangement2 = BeautifulArrangement2()

    private data class BeautifulArrangement2TestData(
        val n: Int,
        val k: Int,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as BeautifulArrangement2TestData

            if (n != other.n) return false
            if (k != other.k) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun constructArray() {
        val tests = listOf(
            BeautifulArrangement2TestData(
                3,
                1,
                intArrayOf(1, 2, 3)
            ),
            BeautifulArrangement2TestData(
                3,
                2,
                intArrayOf(1, 3, 2)
            ),
            BeautifulArrangement2TestData(
                5,
                2,
                intArrayOf(1, 5, 4, 3, 2)
            ),
            BeautifulArrangement2TestData(
                5,
                3,
                intArrayOf(1, 5, 2, 3, 4)
            ),
            BeautifulArrangement2TestData(
                5,
                4,
                intArrayOf(1, 5, 2, 4, 3)
            ),
            BeautifulArrangement2TestData(
                6,
                3,
                intArrayOf(1, 6, 2, 3, 4, 5)
            ),
        )
        tests.forEach { test ->
            beautifulArrangement2.constructArray(test.n, test.k)
                .also {
                    println(it.toList())
                    assertContentEquals(it, test.result)
                }
        }
    }
}
