class Solution2466 {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val mod = 1_000_000_007
        val dp = IntArray(high+1).also{it[0] = 1}
        var res = 0
        (1..high).forEach { i ->
            if (i>=zero) dp[i] = (dp[i]+dp[i-zero])%mod
            if (i>=one) dp[i] = (dp[i]+dp[i-one])%mod
            if (i>=low) res = (res+dp[i])%mod
        }
        return res
    }
}
