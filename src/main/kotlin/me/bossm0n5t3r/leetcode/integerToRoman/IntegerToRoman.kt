package me.bossm0n5t3r.leetcode.integerToRoman

class IntegerToRoman {
    class Solution {
        fun intToRoman(num: Int): String {
            val romanNumerals = mapOf(
                0 to mapOf(
                    1 to "I",
                    5 to "V",
                ),
                1 to mapOf(
                    1 to "X",
                    5 to "L",
                ),
                2 to mapOf(
                    1 to "C",
                    5 to "D",
                ),
                3 to mapOf(1 to "M"),
            )
            val result = mutableListOf<String?>()
            var tmpNum = num
            var idx = 0
            while (tmpNum > 0) {
                val tmp = tmpNum % 10
                val tmpDividedByFive = tmp / 5
                val tmpRemainderWhenDividedByFive = tmp % 5
                if (tmpRemainderWhenDividedByFive == 4) {
                    val tmpRoman = romanNumerals[idx]?.get(1) + if (tmpDividedByFive > 0) {
                        romanNumerals[idx + 1]?.get(1)
                    } else {
                        romanNumerals[idx]?.get(5)
                    }
                    result.add(tmpRoman)
                } else {
                    val tmpRoman = (
                        if (tmpDividedByFive > 0) {
                            romanNumerals[idx]?.get(5)
                        } else {
                            ""
                        }
                        ) + romanNumerals[idx]?.get(1)?.repeat(tmpRemainderWhenDividedByFive)
                    result.add(tmpRoman)
                }
                tmpNum /= 10
                idx++
            }
            return result.filterNotNull().reversed().joinToString("")
        }
    }
}
