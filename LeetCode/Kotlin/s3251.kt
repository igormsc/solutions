class Solution3251 {
    fun countOfPairs(nums: IntArray): Int {
        val n = nums.size
        val MOD = 1_000_000_007
        var dp = IntArray(1001) {1}
        (1..<n).forEach { i ->
            val d = maxOf(nums[i]-nums[i-1], 0)
            val dp2= IntArray(1001)
            (d..nums[i]).forEach { j -> dp2[j] = ( dp[j-d] + if (j>0) dp2[j-1] else 0 )%MOD }
            dp = dp2
        }
        return (0..nums.last()).fold(0) { r, j -> (r+dp[j])%MOD}
    }
}