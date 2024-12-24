class Solution3129 {

    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val MOD = 1_000_000_007
        val dp = Array(zero + 1) { Array(one + 1) { IntArray(2) } }
        (1..minOf(zero, limit)).forEach { dp[it][0][0] = 1 }
        (1..minOf(one, limit)).forEach { dp[0][it][1] = 1 }
        (1..zero).forEach { i ->
            (1..one).forEach { j ->
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD
                if (i > limit) dp[i][j][0] = (dp[i][j][0] + MOD - dp[i - limit - 1][j][1]) % MOD
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD
                if (j > limit) dp[i][j][1] = (dp[i][j][1] + MOD - dp[i][j - limit - 1][0]) % MOD
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD
    }
}