class Solution885 {
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        var dx = 0
        var dy = 1
        var j = 0
        var n = 0
        var rs = rStart
        var cs = cStart
        val res = Array(rows * cols) { IntArray(2) }
        while (j < rows * cols) {
            repeat(n / 2 + 1) {
                if (rs in 0..<rows && cs in 0..<cols) res[j++] = intArrayOf(rs, cs)
                rs += dx
                cs += dy
            }
            dx = dy.also { dy = -dx }
            n++
        }
        return res
    }
}

