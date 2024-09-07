package me.bossm0n5t3r.leetcode.utils

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Node(var `val`: Int) {
    var subNodeStore = mutableListOf<Node?>()

    var children: MutableList<Node?>
        get() = subNodeStore
        set(value) {
            subNodeStore = value
        }

    var neighbors: ArrayList<Node?>
        get() = ArrayList(subNodeStore)
        set(value) {
            subNodeStore = value
        }

    fun addSubNode(subNode: Node) {
        subNodeStore.add(subNode)
    }

    override operator fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (`val` != other.`val`) return false
        if (subNodeStore.toList() != other.subNodeStore.toList()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + subNodeStore.hashCode()
        return result
    }

    override fun toString(): String {
        return "Node(`val`: ${this.`val`}, store: ${this.subNodeStore.toList()})"
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
                    val subNode = Node(requireNotNull(queue.poll()))
                    cur.addSubNode(subNode)
                    nextCandidates.add(subNode)
                }
                if (index < candidates.size) {
                    require(queue.poll() == null) { "queue: $queue, candidates: $candidates, candidatesStack: $candidatesStack" }
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
                val subNodeStore = cur?.subNodeStore
                if (subNodeStore.isNullOrEmpty()) {
                    queue.offer(null)
                    continue
                }
                for (subNode in subNodeStore) {
                    queue.offer(subNode)
                }
            }
            if (queue.isNotEmpty()) {
                result.add(null)
            }
        }
        while (result.isNotEmpty() && result.last() == null) {
            result.removeLast()
        }
        return result
    }
}
