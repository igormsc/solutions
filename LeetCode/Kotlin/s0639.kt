class Solution639 {
    fun numDecodings(s: String): Int {
        val dp = LongArray(s.length+1).also{it[0]=1L}
        s.forEachIndexed { i, c ->
            if (i==0) when {
                c == '*' -> dp[1] = 9L
                c != '0' -> dp[1] = 1L
                }
            else {
                when {
                    c == '*' -> dp[i + 1] = +dp[i] * 9L
                    c != '0' -> dp[i + 1] += dp[i]
                }
                when {
                    (s[i - 1] == '1' && c != '*') || (s[i - 1] == '2' && c <= '6' && c >= '0') -> dp[i + 1] += dp[i - 1]
                    s[i - 1] == '1' && c == '*' -> dp[i + 1] += dp[i - 1] * 9L
                    s[i - 1] == '*' && c >= '0' && c <= '6' -> dp[i + 1] += dp[i - 1] * 2L
                    s[i - 1] == '*' && c > '6' -> dp[i + 1] += dp[i - 1]
                    s[i - 1] == '2' && c == '*' -> dp[i + 1] += dp[i - 1] * 6L
                    s[i - 1] == '*' && c == '*' -> dp[i + 1] += dp[i - 1] * 15L
                }
            }
            dp[i+1] = dp[i+1] % 1_000_000_007L
        }
        return dp.last().toInt()
    }
}
