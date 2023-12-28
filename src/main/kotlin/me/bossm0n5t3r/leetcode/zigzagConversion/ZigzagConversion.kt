package me.bossm0n5t3r.leetcode.zigzagConversion

class ZigzagConversion {
    class Solution {
        fun convert(
            s: String,
            numRows: Int,
        ): String {
            val result = Array(numRows) { mutableListOf<Char>() }
            val index = Index(numRows)
            s.forEach { c ->
                val nextIdx = index.next().idx
                result[nextIdx].add(c)
            }
            return result.joinToString("") { it.joinToString("") }
        }

        private data class Index(val numRows: Int, var idx: Int = -1, var direction: Direction = Direction.DOWN) {
            fun next(): Index {
                when (this.direction) {
                    Direction.DOWN -> {
                        if (idx < numRows - 1) {
                            idx++
                            if (idx == numRows - 1) {
                                this.direction = Direction.UP
                            }
                        }
                    }
                    Direction.UP -> {
                        if (idx > 0) {
                            idx--
                            if (idx == 0) {
                                this.direction = Direction.DOWN
                            }
                        }
                    }
                }
                return this
            }
        }

        private enum class Direction {
            DOWN,
            UP,
        }
    }
}
