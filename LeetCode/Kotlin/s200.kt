class Solution200 {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(i: Int, j: Int) {
            if (i !in 0..grid.lastIndex || j !in 0..grid.first().lastIndex || grid[i][j] != '1') return
            grid[i][j] = '*'
            dfs(i + 1, j)
            dfs(i, j + 1)
            dfs(i - 1, j)
            dfs(i, j - 1)
        }

        return grid.indices.fold(0) { r, i ->
                    grid.first().indices.fold(r) { r, j ->
                        r + if (grid[i][j] == '1') 1.also { dfs(i, j) } else 0
                    }
                }
    }

}
