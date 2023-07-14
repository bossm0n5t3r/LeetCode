package me.bossm0n5t3r.leetcode.utils

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringUtilTest {
    @Test
    fun toArrayOfIntArrayTest() {
        assertThat(
            "[[3,2,1],[1,7,6],[2,7,7]]".toArrayOfIntArray(),
        ).isEqualTo(
            arrayOf(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 7, 6),
                intArrayOf(2, 7, 7),
            ),
        )

        assertThat(
            "[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]".toArrayOfIntArray(),
        ).isEqualTo(
            arrayOf(
                intArrayOf(3, 1, 2, 2),
                intArrayOf(1, 4, 4, 5),
                intArrayOf(2, 4, 2, 2),
                intArrayOf(2, 4, 2, 2),
            ),
        )
    }
}
