package me.bossm0n5t3r.leetcode.doubleANumberRepresentedAsALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class DoubleANumberRepresentedAsALinkedListTest {
    private val sut = DoubleANumberRepresentedAsALinkedList.Solution()
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
                    listNodeUtil.generateListNode(1, 8, 9),
                    listNodeUtil.generateListNode(3, 7, 8),
                ),
                TestData(
                    listNodeUtil.generateListNode(9, 9, 9),
                    listNodeUtil.generateListNode(1, 9, 9, 8),
                ),
            )

        tests.forEach { test ->
            assertTrue {
                listNodeUtil.isEqual(test.result, sut.doubleIt(test.head))
            }
        }
    }
}
