class Solution062 {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = IntArray(n){1}
        (1..<m).forEach { (1..<n).forEach { dp[it] += dp[it-1]} }
        return dp[n-1]
    }
}