package me.bossm0n5t3r.leetcode.middleOfTheLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MiddleOfTheLinkedListTest {
    private val sut = MiddleOfTheLinkedList.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class TestData(
        val head: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4, 5)),
                    listNodeUtil.generateListNodeFromList(listOf(3, 4, 5)),
                ),
                TestData(
                    listNodeUtil.generateListNodeFromList(listOf(1, 2, 3, 4, 5, 6)),
                    listNodeUtil.generateListNodeFromList(listOf(4, 5, 6)),
                ),
            )

        tests.forEach { test ->
            assertTrue(listNodeUtil.isEqual(sut.middleNode(test.head), test.result))
        }
    }
}
