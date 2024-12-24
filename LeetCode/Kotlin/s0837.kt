class Solution837 {
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        if (k==0 || n >= k+maxPts) return 1.0
        val dp = DoubleArray(n+1).also{it[0]=1.0}
        var (res, sum) = 0.0 to 1.0
        (1..n).forEach{ i ->
            dp[i] = sum/(maxPts.toDouble())
            if (i<k) sum += dp[i] else res += dp[i]
            if (i-maxPts >= 0) sum -= dp[i-maxPts]
        }
        return res
    }
}
