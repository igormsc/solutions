class Solution3202 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val dp = Array(k) {IntArray(k)}
        return nums.fold(0) { r, n ->
            (0..<k).fold(r) { r, i ->
                dp[i][n%k] = maxOf(dp[i][n%k], dp[n%k][i] + 1)
                maxOf(r, dp[i][n%k])
            }
        }
    }
}
