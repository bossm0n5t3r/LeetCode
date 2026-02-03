package me.bossm0n5t3r.leetcode.divideanarrayintosubarrayswithminimumcostii

import java.util.TreeMap

class DivideAnArrayIntoSubarraysWithMinimumCostII {
    class Solution {
        class Container(
            private val k: Int,
        ) {
            private var st1Size = 0
            private var st2Size = 0
            private val st1 = TreeMap<Int, Int>()
            private val st2 = TreeMap<Int, Int>()
            var sum = 0L

            private fun removeOne(
                map: TreeMap<Int, Int>,
                key: Int,
            ) {
                val count = map[key] ?: return
                if (count == 1) map.remove(key) else map[key] = count - 1
            }

            private fun addOne(
                map: TreeMap<Int, Int>,
                key: Int,
            ) {
                map[key] = map.getOrDefault(key, 0) + 1
            }

            private fun adjust() {
                while (st1Size < k && st2.isNotEmpty()) {
                    val x = st2.firstKey()
                    addOne(st1, x)
                    st1Size++
                    sum += x
                    removeOne(st2, x)
                    st2Size--
                }
                while (st1Size > k) {
                    val x = st1.lastKey()
                    addOne(st2, x)
                    st2Size++
                    removeOne(st1, x)
                    st1Size--
                    sum -= x
                }
            }

            fun add(x: Int) {
                if (st2.isNotEmpty() && x >= st2.firstKey()) {
                    addOne(st2, x)
                    st2Size++
                } else {
                    addOne(st1, x)
                    st1Size++
                    sum += x
                }
                adjust()
            }

            fun erase(x: Int) {
                if (x in st1) {
                    removeOne(st1, x)
                    st1Size--
                    sum -= x
                } else if (x in st2) {
                    removeOne(st2, x)
                    st2Size--
                }
                adjust()
            }
        }

        fun minimumCost(
            nums: IntArray,
            k: Int,
            dist: Int,
        ): Long {
            val n = nums.size
            val container = Container(k - 2)
            for (i in 1 until k - 1) {
                container.add(nums[i])
            }

            var result = container.sum + nums[k - 1]
            for (i in k until n) {
                val j = i - dist - 1
                if (j > 0) {
                    container.erase(nums[j])
                }
                container.add(nums[i - 1])
                result = minOf(result, container.sum + nums[i])
            }
            return result + nums[0]
        }
    }
}
