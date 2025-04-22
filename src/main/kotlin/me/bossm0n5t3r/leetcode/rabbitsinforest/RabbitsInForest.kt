package me.bossm0n5t3r.leetcode.rabbitsinforest

class RabbitsInForest {
    class Solution {
        fun numRabbits(answers: IntArray): Int {
            var rabbits = 0
            var maxAnswer = 0
            val answerCount = IntArray(1001)
            for (answer in answers) {
                answerCount[answer]++
                if (maxAnswer < answer) {
                    maxAnswer = answer
                }
            }
            for (answer in 0..maxAnswer) {
                rabbits += (answerCount[answer] + answer) / (answer + 1) * (answer + 1)
            }
            return rabbits
        }
    }
}
