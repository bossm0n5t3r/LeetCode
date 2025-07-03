package me.bossm0n5t3r.leetcode.findthekthcharacterinstringgamei

class FindTheKThCharacterInStringGameI {
    class Solution {
        fun kthCharacter(k: Int): Char = 'a' + (k - 1).countOneBits()
    }
}
