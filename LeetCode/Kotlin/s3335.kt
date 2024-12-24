class Solution3335 {
    fun lengthAfterTransformations(s: String, t: Int): Int {
        (0..25).forEach { dp[it]=1 }
        (26..100_099).forEach { dp[it] = (dp[it - 26] + dp[it - 26 + 1]) % MOD }
        return s.indices.fold(0) { r, i -> (r + dp[s[i].code - 'a'.code + t])%MOD }
    }

    private val MOD = 1_000_000_007
    private val dp = IntArray(100_100)
}
