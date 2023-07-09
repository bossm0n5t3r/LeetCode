package me.bossm0n5t3r.leetcode.containerWithMostWater

class ContainerWithMostWater {
    class Solution {
        fun maxArea(height: IntArray): Int {
            var front = 0
            var back = height.lastIndex
            var result = 0
            while (front < back) {
                val curWater = min(height[front], height[back]) * (back - front)
                if (curWater > result) {
                    result = curWater
                }
                if (height[front] < height[back]) {
                    front++
                } else {
                    back--
                }
            }
            return result
        }

        fun maxAreaAt230709(height: IntArray): Int {
            var area = 0
            var (s, e) = 0 to height.size - 1
            while (s < e) {
                val tmp = (e - s) * min(height[s], height[e])
                if (tmp > area) {
                    area = tmp
                }
                if (height[s] < height[e]) s++ else e--
            }
            return area
        }

        private fun min(a: Int, b: Int) = if (a < b) a else b
    }
}
