class Solution934 {
    fun shortestBridge(grid: Array<IntArray>): Int {
        val dirs = intArrayOf(-1, 0, 1, 0, -1)
        val q = mutableListOf<IntArray>()
        val n = grid.size

        fun dfs(u: Int, v: Int) {
            grid[u][v] = 2
            q.add(intArrayOf(u, v))
            for (k in 0..3) {
                val (x, y) = u + dirs[k] to v + dirs[k + 1]
                if (x in grid.indices && y in grid[0].indices && grid[x][y] == 1) dfs(x, y)
            }
        }

        var (i, x) = 0 to 1
        while (i < n && x == 1) {
            for (j in 0..<n)
                if (grid[i][j] == 1) {
                    dfs(i, j)
                    x = 0
                    break
                }
            i++
        }

        var res = 0
        while (true) {
            for (i in q.size downTo 1) {
                val p = q.removeFirst()
                for (k in 0..3) {
                    val (x, y) = p[0] + dirs[k] to p[1] + dirs[k + 1]
                    if (x in grid.indices && y in grid[0].indices) {
                        if (grid[x][y] == 1) return res
                        if (grid[x][y] == 0) {
                            grid[x][y] = 2
                            q.add(intArrayOf(x, y))
                        }
                    }
                }
            }
            res++
        }
    }

}
