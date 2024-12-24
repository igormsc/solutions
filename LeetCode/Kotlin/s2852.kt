class Solution2852 {
    fun sumRemoteness(grid: Array<IntArray>): Long {
        val n = grid.size
        val dirs = intArrayOf(-1, 0, 1, 0, -1)

        var cnt = 0
        for (row in grid)
            for (x in row)
                if (x > 0) cnt++

        fun dfs(i: Int, j: Int): LongArray {
            val res = longArrayOf(grid[i][j].toLong(), 1L)
            grid[i][j] = 0
            for (k in 0..3) {
                val (x, y) = i + dirs[k] to j + dirs[k + 1]
                if (x in 0..<n && y in 0..<n && grid[x][y] > 0) {
                    val t = dfs(x, y)
                    res[0] += t[0]
                    res[1] += t[1]
                }
            }
            return res
        }

        var res = 0L
        for (i in 0..<n)
            for (j in 0..<n)
                if (grid[i][j] > 0) {
                    val rd = dfs(i, j)
                    res += (cnt - rd[1]) * rd[0]
                }
        return res
    }

}