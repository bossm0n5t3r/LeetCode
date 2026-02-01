package me.bossm0n5t3r.leetcode.implementTriePrefixTree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementTriePrefixTreeTest {
    private val trie = ImplementTriePrefixTree.Trie()

    @Test
    fun test() {
        trie.insert("apple")
        assertTrue(trie.search("apple"))
        assertFalse(trie.search("app"))
        assertTrue(trie.startsWith("app"))
        trie.insert("app")
        assertTrue(trie.search("app"))
    }
}
