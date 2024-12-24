class Solution2328 {
    fun countPaths(grid: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val dp = Array(grid.size){IntArray(grid[0].size)}

        fun dfs(i: Int, j: Int, v: Int): Int =
            if (i !in grid.indices || j !in grid[0].indices || grid[i][j] <= v) 0
            else {
                if (dp[i][j] == 0) dp[i][j] = (dfs( i+1, j, grid[i][j]) + dfs( i-1, j, grid[i][j]) + dfs( i, j+1, grid[i][j]) + dfs( i, j-1, grid[i][j]) + 1) % mod
                dp[i][j]
            }

        var res = 0
        grid.indices.forEach { i ->
            grid[0].indices.forEach { j -> res = (res + dfs(i, j, 0))%mod } }
        return res
    }
}
