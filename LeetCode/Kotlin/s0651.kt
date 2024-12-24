class Solution651 {
    fun maxA(n: Int): Int {
        val dp = IntArray(n + 1) {it}
        for (i in 3..<n + 1)
            for (j in 2..<i - 1)
                dp[i] = maxOf(dp[i], (dp[j - 1] * (i - j)))
        return dp[n]
    }

}