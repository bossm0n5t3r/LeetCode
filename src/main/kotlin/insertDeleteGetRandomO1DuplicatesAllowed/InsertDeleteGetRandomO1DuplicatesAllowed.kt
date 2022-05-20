package insertDeleteGetRandomO1DuplicatesAllowed

class InsertDeleteGetRandomO1DuplicatesAllowed {
    private val map = mutableMapOf<Int, MutableSet<Int>>()
    private val values = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        val contain = map.containsKey(`val`)
        map[`val`] = map.getOrDefault(`val`, mutableSetOf())
        values.add(`val`)
        map[`val`]?.add(values.lastIndex)
        return !contain
    }

    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) return false
        val index = map[`val`]?.firstOrNull() ?: return false
        map[`val`]?.remove(index)
        if (index < values.size - 1) {
            val lastIndex = values.lastIndex
            val lastValue = values.last()
            values[index] = lastValue
            map[lastValue]?.remove(lastIndex)
            map[lastValue]?.add(index)
        }
        values.removeAt(values.lastIndex)
        if (map[`val`].isNullOrEmpty()) map.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        val randIndex = (0 until values.size).random()
        return values[randIndex]
    }
}
