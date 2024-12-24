class Solution1254 {
    fun closedIsland(grid: Array<IntArray>): Int {
        fun dfs(i: Int, j: Int): Boolean {
            var res = i in 1..< grid.lastIndex && j in 1..< grid[0].lastIndex
            grid[i][j] = 1
            val dirs = intArrayOf(-1, 0, 1, 0, -1)
            for (k in 0..3) {
                val (x, y) = i + dirs[k] to j + dirs[k + 1]
                if (x in grid.indices && y in grid[0].indices && grid[x][y] == 0) res = res and dfs(x, y)
            }
            return res
        }
        return grid.indices.sumOf { i -> grid[i].indices.count { j -> grid[i][j] == 0 && dfs(i,j) } }
    }
}
