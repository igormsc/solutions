class Solution3180 {
    fun maxTotalReward(rewardValues: IntArray): Int {
        rewardValues.sort()
        val dp = BooleanArray(2*rewardValues.last()+1).also { it[0] = true }
        var res = 0

        rewardValues.forEach { r ->
            (0..<r).forEach {
                if (dp[it]) {
                    dp[it+r] = true
                    res = maxOf(res, it+r)
                }
            }
        }
        return res
    }
}