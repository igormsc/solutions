class Solution1020 {
    fun numEnclaves(grid: Array<IntArray>): Int {

        fun dfs(i: Int, j: Int) {
            if (i !in grid.indices || j !in grid[i].indices || grid[i][j] != 1) return
            grid[i][j] = 0
            dfs(i+1,j)
            dfs(i-1,j)
            dfs(i,j+1)
            dfs(i,j-1)
        }
        grid.indices.forEach { i ->
            grid[i].indices.forEach { j -> if (i*j == 0 || i == grid.lastIndex || j == grid[i].lastIndex) dfs(i, j) } }

        return grid.sumOf { it.sum() }
    }
}
