class Solution3122 {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val dp = Array(1000) { IntArray(10) }
        val cnt = Array(1000) { IntArray(10) }

        fun dfs(i: Int, p: Int): Int = if (i == grid[0].size) 0 else {
                if (dp[i][p] == 0) (0..9).forEach { if (i == 0 || it != p) dp[i][p] = maxOf(dp[i][p], cnt[i][it] + dfs(i + 1, it))}
                dp[i][p] }

        grid.forEach { it.forEachIndexed { j, g -> cnt[j][g]++ } }

        return grid.size * grid[0].size - dfs(0, 0)
    }
}
