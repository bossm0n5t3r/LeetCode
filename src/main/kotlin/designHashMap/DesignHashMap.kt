package designHashMap

class DesignHashMap {
    private val data = IntArray(1_000_000 + 1) { -1 }

    fun put(key: Int, value: Int) {
        data[key] = value
    }

    fun get(key: Int): Int {
        return data[key]
    }

    fun remove(key: Int) {
        data[key] = -1
    }
}
