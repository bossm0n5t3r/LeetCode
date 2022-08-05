package jumpGame2

import java.util.LinkedList

class JumpGame2 {
    fun jump(nums: IntArray): Int {
        val jump = IntArray(nums.size) { 0 }
        val visited = BooleanArray(nums.size) { false }
        val queue = LinkedList<Int>()
        queue.add(0)
        visited[0] = true
        while (queue.isNotEmpty()) {
            val curPos = queue.poll()
            val curJump = jump[curPos]
            val maxJumpLength = nums[curPos]
            (0..maxJumpLength).forEach { i ->
                val nextPos = curPos + i
                if (nextPos < nums.size && !visited[nextPos]) {
                    visited[nextPos] = true
                    jump[nextPos] = curJump + 1
                    queue.add(nextPos)
                }
            }
        }
        return jump[nums.size - 1]
    }
}
