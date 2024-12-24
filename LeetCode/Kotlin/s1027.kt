import kotlin.math.max

class Solution1027 {
    fun longestArithSeqLength(nums: IntArray): Int {
        var res = 0
        val n = nums.size
        val dp = Array(n) { IntArray(1001) }
        for (i in 1..<n)
            for (k in 0..<i) {
                val j = nums[i] - nums[k] + 500
                dp[i][j] = maxOf(dp[i][j], dp[k][j] + 1)
                res = maxOf(res, dp[i][j])
            }
        return res + 1
    }
}
