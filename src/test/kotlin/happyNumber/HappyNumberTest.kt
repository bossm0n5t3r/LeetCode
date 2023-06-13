package happyNumber

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HappyNumberTest {
    private val happyNumber = HappyNumber()

    data class HappyNumberTestData(
        val n: Int,
        val result: Boolean,
    )

    @Test
    fun isHappy() {
        val tests = listOf(
            HappyNumberTestData(19, true),
            HappyNumberTestData(2, false),
        )
        tests.forEach { test ->
            assertEquals(happyNumber.isHappy(test.n), test.result)
        }
    }
}
