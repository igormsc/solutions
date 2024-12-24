class Solution2533 {
    fun goodBinaryStrings(minLength: Int, maxLength: Int, oneGroup: Int, zeroGroup: Int): Int {
        val mod = 1_000_000_007
        val dp = IntArray(maxLength + 1).also{it[0]=1}
        for (i in 1..maxLength) {
            if (i - oneGroup >= 0) dp[i] = (dp[i] + dp[i - oneGroup]) % mod
            if (i - zeroGroup >= 0) dp[i] = (dp[i] + dp[i - zeroGroup]) % mod
        }
        return (minLength..maxLength).fold(0) { r, i -> (r + dp[i]) % mod }
    }

}