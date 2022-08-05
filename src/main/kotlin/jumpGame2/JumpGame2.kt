package jumpGame2

class JumpGame2 {
    fun jump(nums: IntArray): Int {
        var position = nums.size - 1
        var steps = 0
        while (position != 0) {
            for (i in 0 until position) {
                if (nums[i] >= position - i) {
                    position = i
                    steps++
                    break
                }
            }
        }
        return steps
    }
}
