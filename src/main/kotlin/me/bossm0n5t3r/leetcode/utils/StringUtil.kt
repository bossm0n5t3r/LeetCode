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

    fun String.toIntArray(): IntArray {
        return this
            .drop(1)
            .dropLast(1)
            .split(",")
            .map { it.toInt() }
            .toIntArray()
    }

    fun String.toArrayOfCharArray(): Array<CharArray> {
        return this
            .drop(2)
            .dropLast(2)
            .split("],[")
            .map {
                it
                    .replace("\"", "")
                    .split(",")
                    .map { c -> c.first() }
                    .toCharArray()
            }
            .toTypedArray()
    }

    fun String.toArrayOfString(): Array<String> {
        return this
            .drop(1)
            .dropLast(1)
            .replace("\"", "")
            .split(",")
            .toTypedArray()
    }

    fun String.toListOfStringList(): List<List<String>> {
        return this
            .drop(2)
            .dropLast(2)
            .split("],[")
            .map {
                it
                    .replace("\"", "")
                    .split(",")
            }
    }

    fun String.toListOfIntList(): List<List<Int>> {
        if (this == "[]") return emptyList()
        return this
            .drop(2)
            .dropLast(2)
            .split("],[")
            .map {
                it
                    .replace("\"", "")
                    .split(",")
                    .map { s -> s.toInt() }
            }
    }
}
