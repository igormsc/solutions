class Solution790 {
    fun numTilings(n: Int): Int {
        val mod = 1_000_000_007
        val dp = intArrayOf(0, 1, 1)
        repeat(n-1) { dp[0] = dp[1].also{ dp[1] = dp[2].also{ dp[2] = ((2*dp[2])%mod+dp[0])%mod } } }
        return dp[2]
    }
}
