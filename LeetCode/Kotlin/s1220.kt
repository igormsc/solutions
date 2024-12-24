class Solution1220 {
    fun countVowelPermutation(n: Int): Int {
        var dp = LongArray(5) {1L}
        val mod = 1_000_000_007L
        repeat(n-2) { dp = longArrayOf ((dp[1] + dp[2] + dp[4]) % mod, (dp[0] + dp[2]) % mod, (dp[1] + dp[3]) % mod, dp[2], (dp[2] + dp[3]) % mod) }
        return dp.fold(0L) { r, v -> (r + v) % mod }.toInt()
    }
}