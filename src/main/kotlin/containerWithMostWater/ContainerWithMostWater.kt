package containerWithMostWater

import kotlin.math.min

class ContainerWithMostWater {
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
}
