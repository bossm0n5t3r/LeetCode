package me.bossm0n5t3r.leetcode.solvingquestionswithbrainpower

class SolvingQuestionsWithBrainpower {
    class Solution {
        fun mostPoints(questions: Array<IntArray>): Long {
            val n = questions.size
            val dp = LongArray(n + 1)
            for (i in n - 1 downTo 0) {
                val (points, jump) = questions[i]
                dp[i] = maxOf(points + dp[minOf(jump + i + 1, n)], dp[i + 1])
            }
            return dp[0]
        }
    }
}
