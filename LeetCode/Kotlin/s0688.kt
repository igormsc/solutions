class Solution688 {
    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        val dirs = arrayOf(-2 to -1, -1 to -2, 2 to 1, 1 to 2, -2 to 1, 2 to -1, -1 to 2, 1 to -2)
        val dp = Array(26) { Array(26) { DoubleArray(101) } }

        fun dfs(k: Int, i: Int, j: Int): Double =
            when {
                i !in 0..<n || j !in 0..<n -> 0.0
                k == 0 -> 1.0
                dp[i][j][k] != 0.0 -> dp[i][j][k]
                else -> (dirs.sumOf { (x,y) -> dfs(k-1, i + x, j + y) }/8.0).also{dp[i][j][k] = it}
            }
        return dfs(k, row, column)
    }
}
