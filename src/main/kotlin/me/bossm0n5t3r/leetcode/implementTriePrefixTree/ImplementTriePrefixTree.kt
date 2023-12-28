package me.bossm0n5t3r.leetcode.implementTriePrefixTree

class ImplementTriePrefixTree {
    class Trie {
        companion object {
            private const val ALPHABET_SIZE = 26

            private class TrieNode {
                val children = Array<TrieNode?>(ALPHABET_SIZE) { null }
                var isEndOfWord = false
            }
        }

        private val root = TrieNode()

        fun insert(word: String) {
            var walk: TrieNode? = root
            for (c in word) {
                val index = c - 'a'
                if (walk?.children?.get(index) == null) {
                    walk?.children?.set(index, TrieNode())
                }
                walk = walk?.children?.get(index)
            }
            walk?.isEndOfWord = true
        }

        fun search(word: String): Boolean {
            var walk: TrieNode? = root
            for (c in word) {
                val index = c - 'a'
                if (walk?.children?.get(index) == null) return false
                walk = walk.children[index]
            }
            return walk?.isEndOfWord == true
        }

        fun startsWith(prefix: String): Boolean {
            var walk: TrieNode? = root
            for (c in prefix) {
                val index = c - 'a'
                if (walk?.children?.get(index) == null) return false
                walk = walk.children[index]
            }
            return true
        }
    }
}
