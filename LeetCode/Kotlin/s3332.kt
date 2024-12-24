class Solution3332 {
    fun maxScore(n: Int, k: Int, stayScore: Array<IntArray>, travelScore: Array<IntArray>): Int {
        var dp = IntArray(n)
        for (i in 0..<k) {
            val dp2 = dp.clone()
            for (j in 0..<n) dp2[j] += stayScore[i][j]
            for (m in 0..<n)
                for (d in 0..<n)
                    dp2[d] = maxOf(dp2[d], dp[m] + travelScore[m][d])
            dp = dp2
        }
        return dp.max()
    }
}
