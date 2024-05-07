package me.bossm0n5t3r.leetcode.maximumTwinSumOfALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumTwinSumOfALinkedListTest {
    private val sut = MaximumTwinSumOfALinkedList.Solution()
    private val listNodeUtil = ListNodeUtil()

    private data class TestData(
        val head: ListNode?,
        val result: Int,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    listNodeUtil.generateListNode(5, 4, 2, 1),
                    6,
                ),
                TestData(
                    listNodeUtil.generateListNode(4, 2, 2, 3),
                    7,
                ),
                TestData(
                    listNodeUtil.generateListNode(1, 100000),
                    100001,
                ),
            )

        tests.forEach { test ->
            assertEquals(
                sut.pairSum(test.head),
                test.result,
            )
        }
    }
}
