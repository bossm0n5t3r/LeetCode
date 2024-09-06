package me.bossm0n5t3r.leetcode.utils

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()

    fun addNeighbor(neighbor: Node) {
        neighbors.add(neighbor)
    }

    override operator fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (`val` != other.`val`) return false
        if (neighbors.toList() != other.neighbors.toList()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + neighbors.hashCode()
        return result
    }

    override fun toString(): String {
        return "Node(`val`: ${this.`val`}, neighbors: ${this.neighbors.toList()})"
    }
}

object NodeUtil {
    fun generateNodeOrNull(vararg values: Int?): Node? {
        if (values.isEmpty()) return null
        val queue: Queue<Int?> = LinkedList<Int?>().apply { this.addAll(values) }
        val candidatesStack: Stack<List<Node>> = Stack()
        while (queue.isNotEmpty()) {
            if (candidatesStack.isEmpty()) {
                val candidates = mutableListOf<Node>()
                while (queue.peek() != null) {
                    candidates.add(Node(requireNotNull(queue.poll())))
                }
                candidatesStack.push(candidates)
                require(queue.poll() == null) { "queue: $queue, candidates: $candidates, candidatesStack: $candidatesStack" }
                continue
            }
            val candidates = candidatesStack.peek()
            require(candidates.isNotEmpty()) { "queue: $queue, candidatesStack: $candidatesStack" }
            val nextCandidates = mutableListOf<Node>()
            var index = 0
            while (index < candidates.size) {
                val cur = candidates[index++]
                while (queue.isNotEmpty() && queue.peek() != null) {
                    val neighbor = Node(requireNotNull(queue.poll()))
                    cur.addNeighbor(neighbor)
                    nextCandidates.add(neighbor)
                }
            }
            candidatesStack.push(nextCandidates)
            require(queue.poll() == null) { "queue: $queue, candidates: $candidates, candidatesStack: $candidatesStack" }
        }
        return if (candidatesStack.isEmpty() || candidatesStack.first().isEmpty()) null else candidatesStack.first().first()
    }

    fun Node.toList(): List<Int?> {
        val result = mutableListOf<Int?>()
        val queue: Queue<Node?> = LinkedList()
        queue.add(this)
        while (queue.isNotEmpty()) {
            if (queue.all { it == null }) break
            var size = queue.size
            while (size-- > 0) {
                val cur = queue.poll()
                result.add(cur?.`val`)
                for (neighbor in cur?.neighbors ?: emptyList()) {
                    queue.offer(neighbor)
                }
            }
            if (queue.isNotEmpty()) {
                result.add(null)
            }
        }
        return result
    }
}
