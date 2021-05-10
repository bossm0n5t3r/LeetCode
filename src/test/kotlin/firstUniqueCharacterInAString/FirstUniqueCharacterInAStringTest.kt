package firstUniqueCharacterInAString

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FirstUniqueCharacterInAStringTest {
    private val firstUniqueCharacterInAString = FirstUniqueCharacterInAString()

    data class FirstUniqueCharacterInAStringTestData(
        val s: String,
        val result: Int
    )

    @Test
    fun firstUniqChar() {
        val tests = listOf(
            FirstUniqueCharacterInAStringTestData("leetcode", 0),
            FirstUniqueCharacterInAStringTestData("loveleetcode", 2),
            FirstUniqueCharacterInAStringTestData("aabb", -1),
        )

        tests.forEach { test ->
            assertEquals(firstUniqueCharacterInAString.firstUniqChar(test.s), test.result)
        }
    }
}
