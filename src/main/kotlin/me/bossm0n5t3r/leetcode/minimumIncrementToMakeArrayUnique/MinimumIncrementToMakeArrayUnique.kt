package me.bossm0n5t3r.leetcode.minimumIncrementToMakeArrayUnique

class MinimumIncrementToMakeArrayUnique {
    class Solution {
        fun minIncrementForUnique(nums: IntArray): Int {
            val uniqueNums = mutableSetOf<Int>()
            val sortedNums = nums.sorted()

            var count = 0
            for (num in sortedNums) {
                if (uniqueNums.contains(num)) {
                    var tmp = num
                    while (uniqueNums.contains(tmp)) {
                        tmp++
                        count++
                    }
                    uniqueNums.add(tmp)
                    continue
                }
                uniqueNums.add(num)
            }
            return count
        }
    }
}
