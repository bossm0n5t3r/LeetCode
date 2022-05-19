package insertDeleteGetRandomO1

class InsertDeleteGetRandomO1 {
    private val set = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        return if (set.contains(`val`)) {
            false
        } else {
            set.add(`val`)
            true
        }
    }

    fun remove(`val`: Int): Boolean {
        return if (set.contains(`val`)) {
            set.remove(`val`)
            true
        } else {
            false
        }
    }

    fun getRandom(): Int {
        return set.random()
    }
}
