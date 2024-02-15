package me.bossm0n5t3r.leetcode.findPolygonWithTheLargestPerimeter

import java.util.PriorityQueue

class FindPolygonWithTheLargestPerimeter {
    class Solution {
        fun largestPerimeter(nums: IntArray): Long {
            val pq = PriorityQueue<Long> { a, b -> b.compareTo(a) }
            var result = 0L
            var numOfNums = 0
            for (num in nums) {
                pq.add(num.toLong())
                result += num.toLong()
                numOfNums++
            }
            while (pq.isNotEmpty()) {
                val cur = pq.peek()
                if (result - cur > cur && numOfNums >= 3) return result
                result -= pq.poll()
                numOfNums--
            }
            return -1
        }
    }
}
