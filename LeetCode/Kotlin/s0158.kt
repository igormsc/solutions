class Solution158:Reader4() {
    private val buf4 = CharArray(4)
    private var i = 0
    private var sz = 0

    override fun read(buf: CharArray, n: Int): Int {
        var j = 0
        while (j < n) {
            if (i == sz) {
                sz = read4(buf4)
                i = 0
                if (sz == 0) break
            }
            while (j < n && i < sz) buf[j++] = buf4[i++]
        }
        return j
    }
}