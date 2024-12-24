class MovingAverage(size: Int) {
    private val q = mutableListOf<Int>()
    private var s = 0
    private var size = size

    fun next(`val`: Int): Double {
        if (q.size == size) s -= q.removeFirst()
        q.add(`val`)
        s += `val`
        return s * 1.0 / q.size
    }

}