package me.bossm0n5t3r.leetcode.findifarraycanbesorted

class FindIfArrayCanBeSorted {
    class Solution {
        fun canSortArray(nums: IntArray): Boolean {
            val storeNums = mutableListOf<MutableList<Int>>()
            var index = 0
            for (num in nums) {
                if (storeNums.isEmpty()) {
                    storeNums.add(mutableListOf(num))
                    continue
                }
                if (num.countOneBits() != storeNums[index].last().countOneBits()) {
                    storeNums.add(mutableListOf(num))
                    index++
                    continue
                }
                storeNums[index].add(num)
            }
            return storeNums.windowed(2).all { it[0].max() < it[1].min() }
        }
    }
}
