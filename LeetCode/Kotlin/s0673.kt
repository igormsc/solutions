class Solution673 {
    fun findNumberOfLIS(nums: IntArray): Int {
        val res = IntArray(2)
        val dp = Array(nums.size) { IntArray(2) }
        for (i in nums.indices) {
            dp[i][0] = 1
            dp[i][1] = 1
            for (j in i-1 downTo 0) {
                if (dp[i][0]>j+2) break
                if (nums[i]>nums[j])
                    if (dp[j][0]+1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1
                        dp[i][1] = dp[j][1]
                    } else if (dp[j][0] == dp[i][0] -1 ) dp[i][1] += dp[j][1]
            }
            if (dp[i][0] > res[0]) {
                res[0] = dp[i][0]
                res[1] = dp[i][1]
            } else if (dp[i][0] == res[0]) res[1] += dp[i][1]
        }
        return res[1]
    }
}