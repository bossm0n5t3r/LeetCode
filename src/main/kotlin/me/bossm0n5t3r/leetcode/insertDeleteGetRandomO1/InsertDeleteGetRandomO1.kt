package me.bossm0n5t3r.leetcode.insertDeleteGetRandomO1

class InsertDeleteGetRandomO1 {
    class RandomizedSet {
        private val map = mutableMapOf<Int, Int>()
        private val values = IntArray(200_000)
        private var size = -1

        fun insert(`val`: Int): Boolean {
            if (map.containsKey(`val`)) {
                return false
            }
            map[`val`] = ++size
            values[size] = `val`
            return true
        }

        fun remove(`val`: Int): Boolean {
            val index = map[`val`] ?: return false
            map.remove(`val`)
            if (index != size) {
                values[index] = values[size]
                map[values[size]] = index
            }
            size--
            return true
        }

        fun getRandom(): Int {
            val randIndex = (0..size).random()
            return values[randIndex]
        }
    }
}
