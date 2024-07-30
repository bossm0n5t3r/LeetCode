package me.bossm0n5t3r.leetcode.countNumberOfTeams

class CountNumberOfTeams {
    class Solution {
        fun numTeams(rating: IntArray): Int {
            var count = 0
            for (i in 0 until rating.size - 2) {
                val first = rating[i]
                for (j in i + 1 until rating.size - 1) {
                    val second = rating[j]
                    if (first == second) continue
                    val isIncreased = first < second
                    for (k in j + 1 until rating.size) {
                        val third = rating[k]
                        if (isIncreased && second < third) {
                            count++
                            continue
                        }
                        if (isIncreased.not() && second > third) {
                            count++
                            continue
                        }
                    }
                }
            }
            return count
        }
    }
}
