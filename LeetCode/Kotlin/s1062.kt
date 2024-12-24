class Solution1062 {
    fun longestRepeatingSubstring(s: String): Int {
        val n = s.length
        var res = 0
        val dp = Array(n) { IntArray(n) }
        for (i in 0..<n)
            for (j in i + 1..<n)
                if (s[i] == s[j]) {
                    dp[i][j] = if (i > 0) dp[i - 1][j - 1] + 1 else 1
                    res = maxOf(res,dp[i][j])
                }
        return res
    }

}