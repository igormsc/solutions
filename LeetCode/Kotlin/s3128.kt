class Solution3128 {
    fun numberOfRightTriangles(grid: Array<IntArray>): Long {
        val n = grid.size
        val m = grid[0].size
        val r = IntArray(n)
        val c = IntArray(m)
        for (i in 0..<n) {
            for (j in 0..<m) {
                val g = grid[i][j]
                r[i] += g
                c[j] += g
            }
        }
        var res = 0L
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (grid[i][j] == 1) res += (r[i] - 1) * (c[j] - 1)
            }
        }
        return res
    }
}
