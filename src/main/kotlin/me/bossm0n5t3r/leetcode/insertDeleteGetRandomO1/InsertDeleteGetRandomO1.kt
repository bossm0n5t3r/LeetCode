package me.bossm0n5t3r.leetcode.insertDeleteGetRandomO1

class InsertDeleteGetRandomO1 {
    class RandomizedSet {
        private val map = mutableMapOf<Int, Int>()
        private val values = mutableListOf<Int>()

        fun insert(`val`: Int): Boolean {
            return if (map.containsKey(`val`)) {
                false
            } else {
                values.add(`val`)
                map[`val`] = values.lastIndex
                true
            }
        }

        fun remove(`val`: Int): Boolean {
            if (!map.containsKey(`val`)) return false
            val index = map[`val`] ?: return false
            val lastIndex = values.lastIndex
            val lastValue = values.last()
            values[index] = lastValue
            map[lastValue] = index
            map.remove(`val`)
            values.removeAt(lastIndex)
            return true
        }

        fun getRandom(): Int {
            val randIndex = values.indices.random()
            return values[randIndex]
        }
    }
}
