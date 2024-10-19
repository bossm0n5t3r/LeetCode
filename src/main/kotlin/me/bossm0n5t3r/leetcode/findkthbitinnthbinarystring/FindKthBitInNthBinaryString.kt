package me.bossm0n5t3r.leetcode.findkthbitinnthbinarystring

class FindKthBitInNthBinaryString {
    class Solution {
        private val binaryStringList = generateBinaryString()

        fun findKthBit(
            n: Int,
            k: Int,
        ): Char = binaryStringList[n][k]

        private fun generateBinaryString(): List<String> {
            val result = mutableListOf("")
            var tmp = "0"
            repeat(20) {
                result.add(" $tmp")
                tmp = "${tmp}1${tmp.map { if (it == '0') '1' else '0' }.reversed().joinToString("")}"
            }
            return result
        }
    }
}
