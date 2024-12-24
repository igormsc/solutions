class Solution518 {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1).also{it[0]=1}
        coins.forEach { c -> (c..amount).forEach { j -> dp[j] += dp[j-c]} }
        return dp[amount]
    }
}