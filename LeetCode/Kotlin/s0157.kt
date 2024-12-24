class Solution157:Reader4() {
    override fun read(buf: CharArray, n: Int): Int {
        val buf4 = CharArray(4)
        var i = 0
        var v = 5
        while (v >= 4) {
            v = read4(buf4)
            (0..<v).forEach { j->
                buf[i++] = buf4[j]
                if (i >= n) return n
            }
        }
        return i
    }
}

    abstract class Reader4() {
        abstract fun read(buf: CharArray, n: Int): Int
        fun read4(b: CharArray): Int = 0
    }