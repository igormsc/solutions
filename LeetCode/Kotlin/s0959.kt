class Solution959 {
    fun regionsBySlashes(grid: Array<String>): Int {
        val n = grid.size
        val g = Array(n*3) {BooleanArray(n*3)}
        (0..<n).forEach { i ->
            (0..<n).forEach { j ->
                if (grid[i][j] == '/') {
                    g[i*3][j*3+2] = true
                    g[i*3+1][j*3+1] = true
                    g[i*3+2][j*3] = true
                }
                else if (grid[i][j] == '\\') {
                    g[i*3][j*3] = true
                    g[i*3+1][j*3+1] = true
                    g[i*3+2][j*3+2] = true
                }
            }
        }

        fun dfs(i: Int, j: Int): Int =
            if (minOf(i,j) < 0 || maxOf(i,j) >= g.size || g[i][j]) 0
            else {g[i][j] = true; 1 + dfs(i-1,j) + dfs(i+1,j) + dfs(i,j-1) + dfs(i,j+1)}

        return (0..<n*3).sumOf { i -> (0..<n*3).count { j -> dfs(i,j) != 0 } }
    }
}
