class Solution1730 {
    private val dirs = intArrayOf(-1, 0, 1, 0, -1)

    fun getFood(grid: Array<CharArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val q = mutableListOf<IntArray>()
        var i = 0
        var z = 1
        while (i < m && z == 1) {
            for (j in 0..<n)
                if (grid[i][j] == '*') {
                    q.add(intArrayOf(i, j))
                    z = 0
                    break
                }
            i++
        }
        var res = 0
        while (q.isNotEmpty()) {
            res++
            for (t in q.size downTo 1) {
                val p = q.removeFirst()
                for (k in 0..3) {
                    val x = p[0] + dirs[k]
                    val y = p[1] + dirs[k + 1]
                    if (x in 0..<m && y in 0..<n) {
                        if (grid[x][y] == '#') return res
                        if (grid[x][y] == 'O') {
                            grid[x][y] = 'X'
                            q.add(intArrayOf(x, y))
                        }
                    }
                }
            }
        }
        return -1
    }

}