class Solution694 {
    fun numDistinctIslands(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val paths = mutableSetOf<String>()
        val path = StringBuilder()

        fun dfs(i: Int, j: Int, k: Int) {
            val dirs = intArrayOf(-1, 0, 1, 0, -1)
            grid[i][j] = 0
            path.append(k)
            for (h in 1..4) {
                val (x, y) = i + dirs[h - 1] to j + dirs[h]
                if (x in 0..<m && y in 0..<n && grid[x][y] == 1) dfs(x, y, h)
            }
            path.append(k)
        }

        for (i in 0..<m)
            for (j in 0..<n)
                if (grid[i][j] == 1) {
                    dfs(i, j, 0)
                    paths.add(path.toString())
                    path.setLength(0)
                }
        return paths.size
    }

}