class Solution1137 {
    fun tribonacci(n: Int): Int {
        val dp = IntArray(maxOf(n+1,3)).also { it[0] = 0; it[1] = 1; it[2] = 1 }
        (3..n).forEach { dp[it] = dp[it-1] + dp[it-2] + dp[it-3] }
        return dp[n]
    }
}
