class Solution054 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val dirs = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        val res = mutableListOf<Int>()
        val nr = matrix.size
        if (nr == 0) return res
        val nc = matrix[0].size
        if (nc == 0) return res
        val steps = intArrayOf(nc,nr-1)
        var (d, x, y) = intArrayOf(0, 0, -1)
        while (steps[d%2] != 0) {
            (0..<steps[d%2]).forEach { i ->
                val (dx,dy) = dirs[d]
                x += dx
                y += dy
                res.add(matrix[x][y])
            }
            steps[d%2]--
            d = (d+1)%4
        }
        return res
    }
}