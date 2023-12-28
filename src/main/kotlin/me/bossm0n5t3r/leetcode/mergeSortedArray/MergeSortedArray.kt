package me.bossm0n5t3r.leetcode.mergeSortedArray

class MergeSortedArray {
    class Solution {
        fun merge(
            nums1: IntArray,
            m: Int,
            nums2: IntArray,
            n: Int,
        ) {
            if (n == 0) return
            val copyNums1 = nums1.copyOf()
            var totalIndex = 0
            var indexNums1 = 0
            var indexNums2 = 0
            while (indexNums1 < m || indexNums2 < n) {
                if (indexNums1 == m) {
                    (totalIndex until nums1.size).forEach { i ->
                        nums1[i] = nums2[indexNums2]
                        indexNums2++
                    }
                    break
                }
                if (indexNums2 == n) {
                    (totalIndex until nums1.size).forEach { i ->
                        nums1[i] = copyNums1[indexNums1]
                        indexNums1++
                    }
                    break
                }
                val curNums1 = copyNums1[indexNums1]
                val curNums2 = nums2[indexNums2]
                if (curNums1 <= curNums2) {
                    nums1[totalIndex] = curNums1
                    indexNums1++
                } else {
                    nums1[totalIndex] = curNums2
                    indexNums2++
                }
                totalIndex++
            }
        }
    }
}
