package me.bossm0n5t3r.leetcode.numberOfStepsToReduceANumberInBinaryRepresentationToOne

class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    class Solution {
        fun numSteps(s: String): Int {
            var num = s
            var steps = 0
            while (num != "1") {
                if (num.last() == '0') {
                    num = num.dropLast(1)
                } else {
                    val tmp = num.toCharArray()
                    var index = tmp.lastIndex
                    while (index >= 0 && tmp[index] != '0') {
                        tmp[index--] = '0'
                    }
                    num =
                        if (index >= 0) {
                            tmp[index] = '1'
                            tmp.joinToString(separator = "")
                        } else {
                            "1" + tmp.joinToString(separator = "")
                        }
                }
                steps++
            }
            return steps
        }
    }
}
