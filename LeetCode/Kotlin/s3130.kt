class Solution3130 {
    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val MOD = 1_000_000_007L
        val dp = Array(zero + 1) { Array(one + 1) { LongArray(2) } }
        (0..minOf(zero, limit)).forEach { dp[it][0][0] = 1 }
        (0..minOf(one, limit)).forEach { dp[0][it][1] = 1 }
        (1..zero).forEach { i ->
            (1..one).forEach { j ->
                dp[i][j] = longArrayOf(dp[i - 1][j].sum(), dp[i][j - 1].sum())
                if (i > limit) dp[i][j][0] = (dp[i][j][0] + MOD - dp[i - limit - 1][j][1]) % MOD
                if (j > limit) dp[i][j][1] = (dp[i][j][1] + MOD - dp[i][j - limit - 1][0]) % MOD
                dp[i][j][0] %= MOD
                dp[i][j][1] %= MOD
            }
        }
        return (dp.last().last().sum() % MOD).toInt()
    }
}