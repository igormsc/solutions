class Solution1230 {
    fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
        val dp = DoubleArray(target + 1).also { it[0] = 1.0 }
        for (p in prob)
            for (j in target downTo 0)
                dp[j] = dp[j] * (1 - p) + if (j > 0) p * dp[j - 1] else 0.0
        return dp[target]
    }

}