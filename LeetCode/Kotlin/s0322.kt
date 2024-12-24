class Solution322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount+1}.also{it[0]=0}
        (1..amount).forEach { a ->
            coins.forEach { c -> if (c <= a && dp[a] > dp[a-c]+1) dp[a] = dp[a-c] + 1 } }
        return if (dp[amount]>amount) -1 else dp[amount]
    }
}
