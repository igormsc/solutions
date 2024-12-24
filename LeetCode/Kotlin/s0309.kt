class Solution309 {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        val dp = Array(n) { IntArray(2) }.also{it[0][1] = -prices[0]}
        for (i in 1..<n) {
            dp[i][0] = maxOf(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = maxOf(dp[i - 1][1], (if (i > 1) dp[i - 2][0] else 0) - prices[i])
        }
        return dp.last()[0]
    }
}
