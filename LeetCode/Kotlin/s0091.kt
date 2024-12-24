class Solution091 {
    fun numDecodings(s: String): Int {
        val n = s.length
        var dp = Array(n+1) {0}.also{it[n]=1}
        for (i in n-1 downTo 0) {
            if (s[i] == '0') dp[i] = 0
            else {
                dp[i] = dp[i+1]
                if (i < n-1 && (s[i] == '1' || s[i] == '2' && s[i+1] < '7')) dp[i] += dp[i+2]
            }
        }
        return dp[0]
    }
}