package me.bossm0n5t3r.leetcode.shortestsubarraytoberemovedtomakearraysorted

class ShortestSubarrayToBeRemovedToMakeArraySorted {
    class Solution {
        fun findLengthOfShortestSubarray(arr: IntArray): Int {
            var left = 0
            while (left + 1 < arr.size && arr[left] <= arr[left + 1]) left++
            if (left == arr.size - 1) return 0

            var right = arr.size - 1
            while (right > left && arr[right - 1] <= arr[right]) right--
            var result = minOf((arr.size - left - 1), right)

            var i = 0
            var j = right
            while (i <= left && j < arr.size) {
                if (arr[j] >= arr[i]) {
                    result = minOf(result, (j - i - 1))
                    i++
                } else {
                    j++
                }
            }
            return result
        }
    }
}
