package me.bossm0n5t3r.leetcode.checkifnanditsdoubleexist

class CheckIfNAndItsDoubleExist {
    class Solution {
        fun checkIfExist(arr: IntArray): Boolean {
            val set = mutableSetOf<Int>()
            for (num in arr) {
                if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                    return true
                }
                set.add(num)
            }
            return false
        }
    }
}
