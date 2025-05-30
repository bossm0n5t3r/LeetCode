package me.bossm0n5t3r.leetcode.numberofstudentsdoinghomeworkatagiventime

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfStudentsDoingHomeworkAtAGivenTimeTest {
    private val sut = NumberOfStudentsDoingHomeworkAtAGivenTime.Solution()

    private data class TestData(
        val startTime: IntArray,
        val endTime: IntArray,
        val queryTime: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (queryTime != other.queryTime) return false
            if (result != other.result) return false
            if (!startTime.contentEquals(other.startTime)) return false
            if (!endTime.contentEquals(other.endTime)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = queryTime
            result1 = 31 * result1 + result
            result1 = 31 * result1 + startTime.contentHashCode()
            result1 = 31 * result1 + endTime.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,2,3]".toIntArray(), "[3,2,7]".toIntArray(), 4, 1),
                TestData("[4]".toIntArray(), "[4]".toIntArray(), 4, 1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.busyStudent(testData.startTime, testData.endTime, testData.queryTime),
            )
        }
    }
}
