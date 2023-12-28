package me.bossm0n5t3r.leetcode.keysAndRooms

import java.util.Stack

class KeysAndRooms {
    class Solution {
        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
            val visited = BooleanArray(rooms.size) { false }
            val keys =
                Stack<Int>().apply {
                    for (key in rooms[0]) {
                        this.push(key)
                    }
                    visited[0] = true
                }
            while (keys.isNotEmpty()) {
                val cur = keys.pop()
                visited[cur] = true
                for (key in rooms[cur]) {
                    if (visited[key].not()) {
                        keys.push(key)
                    }
                }
            }
            return visited.all { it }
        }
    }
}
