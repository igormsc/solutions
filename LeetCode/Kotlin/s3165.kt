class Solution3165 {
    fun maximumSumSubsequence(nums: IntArray, queries: Array<IntArray>): Int {
        val dp = (0..nums.lastIndex).fold(LongArray(nums.size+1)) { r, i -> r[i+1] = maxOf(nums[i].toLong() - r[i], 0L) ;r}
        var sum = dp.sum()
        var res = 0L
        queries.forEach { q ->
            nums[q[0]] = q[1]
            for (i in q[0]..nums.lastIndex) {
                val t = maxOf(nums[i].toLong()-dp[i], 0L)
                if (t == dp[i+1]) break
                sum += t- dp[i+1]
                dp[i+1] = t
            }
            res += sum
        }
        return (res % 1_000_000_007).toInt()
    }

}
