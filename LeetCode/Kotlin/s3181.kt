class Solution3181 {
    fun maxTotalReward(rewardValues: IntArray): Int {
        rewardValues.sort()
        val dp = IntArray(50_000)
        rewardValues.indices.forEach { i ->
            if (i==0 || rewardValues[i-1] != rewardValues[i]) {
                val m = minOf(rewardValues.last() - rewardValues[i], rewardValues[i])
                (0..<m).forEach { j ->
                    dp[rewardValues[i] + dp[j]] = rewardValues[i] + dp[j]
                }
            }
        }
        return rewardValues.last() + dp.slice(0..rewardValues.last()).max()
    }
}
