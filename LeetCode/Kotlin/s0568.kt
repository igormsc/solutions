class Solution568 {
    fun maxVacationDays(flights: Array<IntArray>, days: Array<IntArray>): Int {
        val n = flights.size
        val m = days[0].size
        val dp = Array(m + 1) { IntArray(n) { Int.MIN_VALUE/2} }
        dp[0][0] = 0
        for (k in 1..m)
            for (j in 0..<n) {
                dp[k][j] = dp[k - 1][j]
                for (i in 0..<n)
                    if (flights[i][j] == 1)
                        dp[k][j] = maxOf(dp[k][j], dp[k - 1][i])
                dp[k][j] += days[j][k - 1]
            }
        return dp[m].max()
    }

}