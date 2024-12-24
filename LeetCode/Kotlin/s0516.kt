class Solution516 {
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        val dp = Array(n+1) { IntArray(n+1) }
        (1..dp.lastIndex).forEach { i ->
            (1..dp.lastIndex).forEach { j ->
                dp[i][j] = if (s[i-1]==s[n-j])  dp[i-1][j-1] + 1 else maxOf(dp[i][j-1], dp[i-1][j]) } }
        return dp[n][n]
    }
}
