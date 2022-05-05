package implementStackUsingQueues

import java.util.LinkedList
import java.util.Queue

class ImplementStackUsingQueues {
    private val queue: Queue<Int> = LinkedList()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        val queueSize = queue.size
        repeat(queueSize - 1) {
            val front = queue.poll()
            queue.add(front)
        }
        return queue.poll()
    }

    fun top(): Int {
        val queueSize = queue.size
        repeat(queueSize - 1) {
            val front = queue.poll()
            queue.add(front)
        }
        val top = queue.poll()
        queue.add(top)
        return top
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}
