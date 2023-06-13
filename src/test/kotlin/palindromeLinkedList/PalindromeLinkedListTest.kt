package palindromeLinkedList

import org.junit.jupiter.api.Test
import utils.ListNode
import utils.ListNodeUtil
import kotlin.test.assertEquals

class PalindromeLinkedListTest {
    private val palindromeLinkedList = PalindromeLinkedList()
    private val listNodeUtil = ListNodeUtil()

    data class PalindromeLinkedListTestData(
        val head: ListNode?,
        val result: Boolean,
    )

    @Test
    fun isPalindrome() {
        val tests = listOf(
            PalindromeLinkedListTestData(
                listNodeUtil.generateListNodeFromList(listOf(1, 2, 2, 1)),
                true,
            ),
            PalindromeLinkedListTestData(
                listNodeUtil.generateListNodeFromList(listOf(1, 2, 1, 2, 1)),
                true,
            ),
            PalindromeLinkedListTestData(
                listNodeUtil.generateListNodeFromList(listOf(1, 2)),
                false,
            ),
        )
        tests.forEach { test ->
            assertEquals(palindromeLinkedList.isPalindrome(test.head), test.result)
        }
    }
}
