class Solution3250 {
    fun countOfPairs(nums: IntArray): Int {
        val MOD = 1_000_000_007
        val n = nums.size
        var dp = IntArray(1001) { 1 }
        (1..<n).forEach{ i ->
            val d = maxOf(0, nums[i]-nums[i-1])
            val dp1 = IntArray(1001)
            (d..nums[i]).forEach{ j -> dp1[j] = ((if (j>0) dp1[j-1] else 0) + dp[j-d])%MOD }
            dp = dp1
        }
        return (0..nums.last()).fold(0){ r, j -> (r+dp[j])%MOD }
    }
}
