package me.bossm0n5t3r.leetcode.addTwoNumbers

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class AddTwoNumbersTest {
    private val addTwoNumbers = AddTwoNumbers.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class AddTwoNumbersTestData(
        val l1: ListNode?,
        val l2: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun addTwoNumbers() {
        val tests =
            listOf(
                AddTwoNumbersTestData(
                    listNodeUtil.generateListNodeFromList(listOf(2, 4, 3)),
                    listNodeUtil.generateListNodeFromList(listOf(5, 6, 4)),
                    listNodeUtil.generateListNodeFromList(listOf(7, 0, 8)),
                ),
                AddTwoNumbersTestData(
                    listNodeUtil.generateListNodeFromList(listOf(0)),
                    listNodeUtil.generateListNodeFromList(listOf(0)),
                    listNodeUtil.generateListNodeFromList(listOf(0)),
                ),
                AddTwoNumbersTestData(
                    listNodeUtil.generateListNodeFromList(listOf(9, 9, 9, 9, 9, 9, 9)),
                    listNodeUtil.generateListNodeFromList(listOf(9, 9, 9, 9)),
                    listNodeUtil.generateListNodeFromList(listOf(8, 9, 9, 9, 0, 0, 0, 1)),
                ),
            )
        tests.forEach { test ->
//            println(listNodeUtil.listNodeToList(addTwoNumbers.addTwoNumbers(test.l1, test.l2)))
            assertTrue(listNodeUtil.isEqual(addTwoNumbers.addTwoNumbers(test.l1, test.l2), test.result))
        }
    }
}
