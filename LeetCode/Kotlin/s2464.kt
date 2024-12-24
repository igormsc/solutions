class Solution2464 {
    fun validSubarraySplit(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray(n)

        fun dfs(i: Int): Int =
            when {
                i >= n      -> 0
                dp[i] > 0   -> dp[i]
                else        -> {
                    var res = Int.MAX_VALUE/2
                    for (j in i..<n)
                        if (gcd(nums[i], nums[j]) > 1)
                            res = minOf(res, (1 + dfs(j + 1)))
                    dp[i] = res
                    res
                }
            }
        return dfs(0).let { if (it < Int.MAX_VALUE/2) it else -1 }
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

}