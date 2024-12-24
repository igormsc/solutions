class Solution486 {
    fun predictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        if (n <= 0 || (n.and(1) == 0)) return true
        val dp = IntArray(n)
        nums.indices.reversed().forEach { i ->
            (i..nums.lastIndex).forEach { j -> if (i==j) dp[i] = nums[i] else dp[j] = maxOf(nums[i]-dp[j], nums[j]-dp[j-1])} }
        return dp.last() >= 0
    }
}
