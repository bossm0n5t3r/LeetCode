package me.bossm0n5t3r.leetcode.checkifnumberisasumofpowersofthree

class CheckIfNumberIsASumOfPowersOfThree {
    class Solution {
        fun checkPowersOfThree(n: Int): Boolean = n.toString(3).all { it == '0' || it == '1' }
    }
}
