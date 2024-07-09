package me.bossm0n5t3r.leetcode.findTheWinnerOfTheCircularGame

class FindTheWinnerOfTheCircularGame {
    class Solution {
        fun findTheWinner(
            n: Int,
            k: Int,
        ): Int {
            var friends = (1..n).toList()
            while (friends.size > 1) {
                val index = if (k - 1 < friends.size) k - 1 else (k - 1) % friends.size
                friends = friends.subList(index + 1, friends.size) + friends.subList(0, index)
            }
            return friends.first()
        }
    }
}
