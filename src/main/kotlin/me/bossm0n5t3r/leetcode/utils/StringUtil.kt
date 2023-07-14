package me.bossm0n5t3r.leetcode.utils

object StringUtil {
    fun String.toArrayOfIntArray(): Array<IntArray> {
        return this
            .drop(2)
            .dropLast(2)
            .split("],[")
            .map {
                it
                    .split(",")
                    .map { c -> c.toInt() }
                    .toIntArray()
            }
            .toTypedArray()
    }
}
