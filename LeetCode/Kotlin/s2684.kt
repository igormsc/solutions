class Solution2684 {
    fun maxMoves(grid: Array<IntArray>): Int {
        val (m,n) = grid.size to grid[0].size
        val dp = Array(2) {IntArray(m)}
        (n-2 downTo 0).forEach { c ->
            (0..<m).forEach { r ->
                val c0 = c%2
                val c1 = (c+1)%2
                dp[c0][r] = if (grid[r][c+1] > grid[r][c]) dp[c1][r] + 1 else 0
                if (r>0 && grid[r-1][c+1] > grid[r][c]) dp[c0][r] = maxOf(dp[c0][r], dp[c1][r-1]+1)
                if (r+1<m && grid[r+1][c+1] > grid[r][c]) dp[c0][r] = maxOf(dp[c0][r], dp[c1][r+1]+1)
            }
        }
        return dp[0].max()
    }
}
