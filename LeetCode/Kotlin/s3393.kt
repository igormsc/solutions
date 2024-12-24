class Solution3393 {
    fun countPathsWithXorValue(grid: Array<IntArray>, k: Int): Int {
        val mod = 1_000_000_007
        val (m, n) = grid.lastIndex to  grid[0].lastIndex
        val dp = Array(m+1) { Array(n+1) { IntArray(17) {-1} } }

        fun dfs(i: Int, j: Int, y: Int): Int = when {
            i == m && j == n  -> if (y == k) 1 else 0
            dp[i][j][y] != -1 -> dp[i][j][y]
            else -> (((if (i<m) dfs(i + 1, j, y xor grid[i+1][j]) else 0) + if (j<n) dfs(i, j + 1, y xor grid[i][j+1]) else 0) % mod).also { dp[i][j][y] = it } }

        return dfs(0, 0, grid[0][0])
    }
}