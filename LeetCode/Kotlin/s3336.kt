class Solution3336 {
    fun subsequencePairCount(nums: IntArray): Int {
        val MOD = 1_000_000_007
        val mx = nums.max()
        var dp = Array(mx+1) {IntArray(mx+1)}.also{it[0][0]=1}
        nums.forEach { n ->
            val dp2 = Array(mx+1) {IntArray(mx+1)}
            (mx downTo 0).forEach { i ->
                (mx downTo 0).forEach { j ->
                    val (i2,j2) = gcd(i,n) to gcd(j,n)
                    dp2[i2][j] = (dp2[i2][j] + dp[i][j]) % MOD
                    dp2[i][j2] = (dp2[i][j2] + dp[i][j]) % MOD
                    dp2[i][j] = (dp2[i][j] + dp[i][j]) % MOD
                }
            }
            dp = dp2
        }
        return (1..mx).fold(0) { r, i -> (r+dp[i][i])%MOD}
    }

    fun gcd(a: Int, b: Int): Int = if (b>0) gcd(b,a%b) else a
}
