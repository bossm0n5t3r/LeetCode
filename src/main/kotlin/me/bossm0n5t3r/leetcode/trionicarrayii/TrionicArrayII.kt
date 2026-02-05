package me.bossm0n5t3r.leetcode.trionicarrayii

class TrionicArrayII {
    class Solution {
        fun maxSumTrionic(nums: IntArray): Long {
            val n = nums.size
            var result = Long.MIN_VALUE

            var i = 0
            while (i < n) {
                var j = i + 1
                var tmpResult = 0L

                // first segment: increasing segment
                while (j < n && nums[j - 1] < nums[j]) {
                    j++
                }
                val p = j - 1

                if (p == i) {
                    i++
                    continue
                }

                // second segment: decreasing segment
                tmpResult += (nums[p] + nums[p - 1]).toLong()
                while (j < n && nums[j - 1] > nums[j]) {
                    tmpResult += nums[j].toLong()
                    j++
                }
                val q = j - 1

                if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
                    i = q
                    i++
                    continue
                }

                // third segment: increasing segment
                tmpResult += nums[q + 1].toLong()

                // find the maximum sum of the third segment
                var maxSum: Long = 0
                var sum: Long = 0
                run {
                    var k = q + 2
                    while (k < n && nums[k] > nums[k - 1]) {
                        sum += nums[k].toLong()
                        maxSum = maxOf(maxSum, sum)
                        k++
                    }
                }
                tmpResult += maxSum

                // find the maximum sum of the first segment
                maxSum = 0
                sum = 0
                for (k in p - 2 downTo i) {
                    sum += nums[k].toLong()
                    maxSum = maxOf(maxSum, sum)
                }
                tmpResult += maxSum

                // update answer
                result = maxOf(result, tmpResult)
                i = q - 1
                i++
            }

            return result
        }
    }
}
