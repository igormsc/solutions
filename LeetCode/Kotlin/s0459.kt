class Solution459 {
    fun repeatedSubstringPattern(s: String): Boolean {
        var (i, j) = 1 to 0
        val n = s.length
        val dp = IntArray(n+1)
        while (i<s.length)
            if (s[i] == s[j]) dp[++i] = ++j
            else if (j==0) i++ else j = dp[j]
        return dp[n] != 0 && dp[n]%(n-dp[n]) == 0
    }
}
