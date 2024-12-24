class Solution3205 {
    fun maxScore(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n)
        for (j in 1..<n)
            for (i in 0..<j)
                dp[j] = maxOf(dp[j], dp[i] + (j - i) * nums[j])
        return dp[n - 1]
    }

}