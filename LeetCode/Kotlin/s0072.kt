class Solution072 {
    fun minDistance(word1: String, word2: String): Int {
        val (m, n) = word1.length to word2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        (1..n).forEach { dp[0][it] = it }
        for (i in 1..m) {
            dp[i][0] = i
            for (j in 1..n)
                if (word1[i - 1] == word2[j - 1]) dp[i][j] = dp[i - 1][j - 1]
                else dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        }
        return dp[m][n]
    }
}