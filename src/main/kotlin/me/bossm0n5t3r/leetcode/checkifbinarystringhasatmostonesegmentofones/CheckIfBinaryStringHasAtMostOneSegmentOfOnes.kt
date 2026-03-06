package me.bossm0n5t3r.leetcode.checkifbinarystringhasatmostonesegmentofones

class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    class Solution {
        fun checkOnesSegment(s: String): Boolean = s.contains("01").not()
    }
}
