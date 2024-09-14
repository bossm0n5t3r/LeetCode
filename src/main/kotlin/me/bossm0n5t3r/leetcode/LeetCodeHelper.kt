package me.bossm0n5t3r.leetcode

object LeetCodeHelper {
    private val regex = Regex("[^a-zA-Z0-9]")

    fun String.toLowerCase() = this.substringAfter(". ").replace(regex, "").lowercase()
}
