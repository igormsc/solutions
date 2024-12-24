class Solution063 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val (m, n) = obstacleGrid.size to obstacleGrid[0].size
        val dp = Array(m) { IntArray(n) }
        var i = 0
        while (i < m && obstacleGrid[i][0] == 0) dp[i++][0] = 1
        i = 0
        while (i < n && obstacleGrid[0][i] == 0) dp[0][i++] = 1
        for (i in 1..<m)
            for (j in 1..<n)
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[m - 1][n - 1]
    }
}