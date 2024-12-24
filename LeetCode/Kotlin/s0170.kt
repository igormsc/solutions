class TwoSum() {

    private val cnt = mutableMapOf<Int, Int>()

    fun add(number: Int) = cnt.merge(number, 1) { a: Int?, b: Int? -> a!! + b!! }

    fun find(value: Int): Boolean {
        for ((x, v) in cnt)
            (value - x).also { if (cnt.containsKey(it) && (x != it || v > 1)) return true }
        return false
    }

}