package me.bossm0n5t3r.leetcode.numberOfSeniorCitizens

class NumberOfSeniorCitizens {
    class Solution {
        fun countSeniors(details: Array<String>): Int {
            return details.count { it.substring(11, 13).toInt() > 60 }
        }
    }
}
