package me.bossm0n5t3r.leetcode.implementTriePrefixTree

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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
