class Solution695 {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        fun dfs(i: Int, j: Int): Int {
            if (grid[i][j] == 0) return 0
            grid[i][j] = 0
            val dirs = intArrayOf(-1, 0, 1, 0, -1)
            return (0..3).sumOf { k ->
                        val (x, y) = i + dirs[k] to j + dirs[k + 1]
                        if (x in grid.indices && y in grid[0].indices) dfs(x, y) else 0 } + 1
        }

        return grid.indices.maxOf { i -> grid[i].indices.maxOf { j -> dfs(i, j) } }
    }
}
