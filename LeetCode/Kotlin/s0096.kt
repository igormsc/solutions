class Solution096 {
    fun numTrees(n: Int): Int {
        val dp = IntArray(n + 1).also{it[0]=1; it[1]=1}
        (2..n).forEach { i ->
            dp[i] = 0
            (1..i).forEach { dp[i] += dp[it-1] * dp[i-it]}
        }
        return dp[n]
    }
}
