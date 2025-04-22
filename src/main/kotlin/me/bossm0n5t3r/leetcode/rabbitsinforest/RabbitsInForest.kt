package me.bossm0n5t3r.leetcode.rabbitsinforest

class RabbitsInForest {
    class Solution {
        fun numRabbits(answers: IntArray): Int {
            var rabbits = 0
            val answerToCount = answers.toList().groupingBy { it }.eachCount()
            for ((answer, count) in answerToCount) {
                rabbits += if (count % (answer + 1) == 0) {
                    (count / (answer + 1))
                } else {
                    (count / (answer + 1)) + 1
                } * (answer + 1)
            }
            return rabbits
        }
    }
}
