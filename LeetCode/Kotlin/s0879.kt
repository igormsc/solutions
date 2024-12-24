class Solution879 {
    fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
        val mod = 1_000_000_007
        val dp = Array(group.size+1) { Array(minProfit+1) {IntArray(n+1) {Int.MIN_VALUE} } }

        fun dfs(i: Int, j: Int, k: Int): Int {
            if (i == 0) return if (j <= 0) 1 else 0
            val j = if (j<0) 0 else j
            if (dp[i][j][k] != Int.MIN_VALUE) return dp[i][j][k]
            var res = dfs(i-1, j, k)
            if (k >= group[i-1]) res += dfs(i-1, j-profit[i-1], k-group[i-1])
            res %= mod
            dp[i][j][k] = res
            return res
        }
        return dfs(group.size, minProfit, n)
    }
}
