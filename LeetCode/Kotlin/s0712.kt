class Solution712 {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val (m,n) = s1.length to s2.length
        val dp = IntArray(n+1)
        (1..dp.lastIndex).forEach { dp[it] = dp[it-1] + s2[it-1].code}
        (1..m).forEach { i ->
            var t1 = dp[0]
            dp[0] += s1[i-1].code
            (1..n).forEach { j ->
                val t2 = dp[j]
                dp[j] = if (s1[i-1] == s2[j-1]) t1 else minOf(dp[j] + s1[i-1].code, dp[j-1] + s2[j-1].code)
                t1 = t2
            }
        }
        return dp[n]
    }
}
