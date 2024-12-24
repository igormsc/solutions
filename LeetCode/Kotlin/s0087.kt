class Solution087 {
    fun isScramble(s1: String, s2: String): Boolean {
        val n = s1.length
        val dp = Array(n) { Array(n) { arrayOfNulls<Boolean>(n + 1) } }

        fun dfs(i: Int, j: Int, k: Int): Boolean {
            if (dp[i][j][k] != null) return dp[i][j][k]!!
            if (k == 1) return s1[i] == s2[j]
            for (h in 1..<k) {
                if (dfs(i, j, h) && dfs(i + h, j + h, k - h)) return true.also { dp[i][j][k] = true }
                if (dfs(i + h, j, k - h) && dfs(i, j + k - h, h)) return true.also { dp[i][j][k] = true }
            }
            return false.also { dp[i][j][k] = false }
        }

        return dfs(0, 0, n)
    }

}
