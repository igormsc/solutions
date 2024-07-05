import kotlin.math.absoluteValue

class Solution3098 {
    fun sumOfPowers(nums: IntArray, k: Int): Int {
        var dp = Array(50) { Array(50) {IntArray(2) {-1} } }
        val mod = 1_000_000_007
        fun dfs (i: Int, p: Int, k: Int, pwr: Int, eq: Int): Int {
            if (k == 0) return if (eq != 0) pwr else 0
            if (i >= nums.size) return 0
            if (dp[p][k][eq] == -1) {
                dp[p][k][eq] = dfs(i+1, p, k, pwr, eq)
                if ((nums[i]-nums[p]).absoluteValue >= pwr) dp[p][k][eq] = (dp[p][k][eq] + dfs(i+1, i, k-1, pwr, if (eq != 0 || nums[i] - nums[p] == pwr) 1 else 0)) %mod
            }
            return dp[p][k][eq]
        }
        var res = 0L
        nums.sort()
        val pwrs = mutableSetOf<Int>()
        (0..nums.lastIndex).forEach { i ->
            (i+1..nums.lastIndex).forEach { j ->
                if (nums[i] != nums[j] && pwrs.add(nums[j] - nums[i])) {
                    dp = Array(50) { Array(50) {IntArray(2) {-1} } }
                    res = (res + dfs(0, nums.lastIndex, k, nums[j] - nums[i], 0)) % mod
                }
            }

        }
        return res.toInt()
    }

}
