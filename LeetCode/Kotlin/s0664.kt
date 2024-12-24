class Solution664 {
    fun strangePrinter(s: String): Int {
        val dp = Array(100){IntArray(100)}

        fun dfs(l: Int, r: Int): Int =
            when {
                l > r        -> 0
                dp[l][r] > 0 -> dp[l][r]
                else         -> (dfs(l, r-1) + 1)
                                .also {
                                    dp[l][r] = it
                                    (l..<r).forEach { if (s[it] == s[r]) dp[l][r] = minOf(dp[l][r], dfs(l,it) + dfs(it+1, r-1)) }
                                }
            }
        return dfs(0, s.lastIndex)
    }
}