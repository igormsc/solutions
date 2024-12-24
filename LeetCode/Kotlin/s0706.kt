
class MyHashMap {
    private val data = IntArray(1000001) {-1}

    fun put(key: Int, value: Int) {
        data[key] = value
    }

    fun get(key: Int): Int = data[key]

    fun remove(key: Int) {
        data[key] = -1
    }
}