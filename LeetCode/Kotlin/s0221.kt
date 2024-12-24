class Solution221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val (m, n) = matrix.size to matrix[0].size
        val dp = Array(m + 1) { IntArray(n + 1) }
        var mx = 0
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = minOf(dp[i][j + 1], dp[i + 1][j], dp[i][j]) + 1
                    mx = maxOf(mx, dp[i + 1][j + 1])
                }
        return mx * mx
    }
}
