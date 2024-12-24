class Solution2044 {
    fun countMaxOrSubsets(nums: IntArray): Int {
        var mx = 0
        val dp = IntArray(1.shl(17)).also { it[0] = 1 }
        nums.forEach { n ->
            (mx downTo 0).forEach {
                dp[it or n] += dp[it]
                mx = mx.or(n)
            }
        }
        return dp[mx]
    }
}
