package smallestStringWithSwaps

class SmallestStringWithSwaps {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val node = IntArray(s.length) { it }
        pairs.forEach { (x, y) -> union(node, x, y) }
        val sameRoots = Array(s.length) { mutableListOf<Int>() }
        node.indices.forEach { sameRoots[find(node, it)].add(it) }
        val result = s.toCharArray()
        sameRoots.forEach { swapCharacters(result, it) }
        return result.joinToString("")
    }

    private fun find(node: IntArray, x: Int): Int {
        return if (node[x] == x) {
            x
        } else {
            node[x] = find(node, node[x])
            node[x]
        }
    }

    private fun union(node: IntArray, x: Int, y: Int) {
        val xRoot = find(node, x)
        val yRoot = find(node, y)
        if (xRoot == yRoot) return
        if (xRoot > yRoot) {
            node[xRoot] = yRoot
        } else {
            node[yRoot] = xRoot
        }
    }

    private fun swapCharacters(charArray: CharArray, indices: List<Int>) {
        if (indices.isEmpty()) return
        val sortedTargetCharacters = indices.map { charArray[it] }.sorted()
        indices.forEachIndexed { index, i ->
            charArray[i] = sortedTargetCharacters[index]
        }
    }
}
