class Solution120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = IntArray(triangle.size + 1)
        for (i in triangle.lastIndex downTo 0)
            for (j in 0..i)
                dp[j] = minOf(dp[j], dp[j + 1]) + triangle[i][j]
        return dp[0]
    }
}
