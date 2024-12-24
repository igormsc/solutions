class Vector2D(vec: Array<IntArray>) {

    private var i = 0
    private var j = 0
    private val vec = vec


    fun next(): Int {
        forward()
        return vec[i][j++]
    }

    fun hasNext(): Boolean {
        forward()
        return i < vec.size
    }

    private fun forward() {
        while (i < vec.size && j >= vec[i].size) {
            i++
            j = 0
        }
    }

}
