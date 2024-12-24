class Solution3381 {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val ps = nums.map{it.toLong()}.runningFold(0L,Long::plus)
        val dp = LongArray(nums.size+1) {Long.MIN_VALUE/4}
        (k..nums.size).forEach { dp[it] = ps[it] - ps[it-k] + maxOf(0, dp[it-k])}
        return dp.max()
    }
}
