class Solution2431 {
    fun maxTastiness(price: IntArray, tastiness: IntArray, maxAmount: Int, maxCoupons: Int): Int {
        val dp = Array(price.size + 1) { Array(maxAmount + 1) { IntArray(maxCoupons + 1) } }

        fun dfs(i: Int, j: Int, k: Int): Int {
            if (i < price.size && dp[i][j][k] == 0)
                dp[i][j][k] = maxOf(dfs(i+1,j,k), if (j<price[i]) 0 else tastiness[i] + dfs(i+1,j-price[i],k), if (j < price[i]/2 || k == 0) 0 else tastiness[i] + dfs(i+1,j-price[i]/2,k-1)) + 1
            return maxOf(dp[i][j][k]-1, 0)
        }

        return dfs(0, maxAmount, maxCoupons)
    }

}
