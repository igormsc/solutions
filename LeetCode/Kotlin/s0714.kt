class Solution714 {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val n = prices.size
        val dp = Array(n) { IntArray(2) }.also{it[0][1] = -prices[0]}
        for (i in 1..<n) {
            dp[i][0] = maxOf(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
            dp[i][1] = maxOf(dp[i - 1][1], dp[i - 1][0] - prices[i])
        }
        return dp.last()[0]
    }
}
