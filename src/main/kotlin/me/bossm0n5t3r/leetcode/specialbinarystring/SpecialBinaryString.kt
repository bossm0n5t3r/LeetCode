package me.bossm0n5t3r.leetcode.specialbinarystring

class SpecialBinaryString {
    class Solution {
        fun makeLargestSpecial(s: String): String {
            var count = 0
            var i = 0
            val result = mutableListOf<String>()

            for (j in 0..<s.length) {
                // Track balance: +1 for '1', -1 for '0'
                if (s[j] == '1') count++ else count--

                // Found a balanced chunk when the count returns to 0
                if (count == 0) {
                    // Recursively maximize the inner part, wrap with 1...0
                    result += "1${makeLargestSpecial(s.substring(i + 1, j))}0"
                    i = j + 1 // Move to the next potential chunk
                }
            }

            // Sort chunks in descending order for the largest arrangement
            return result.sortedByDescending { it }.joinToString("")
        }
    }
}
