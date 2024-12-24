class Solution808 {
    fun soupServings(n: Int): Double {
        if (n>4800) return 1.0
        val dp = Array(200) { DoubleArray(200) }

        fun fs(i: Int, j: Int): Double =
            when {
                i <= 0 && j <= 0 -> 0.5
                i <= 0 -> 1.0
                j <= 0 -> 0.0
                dp[i][j] > 0 -> dp[i][j]
                else -> ((fs(i-4, j) + fs(i-3, j-1) + fs(i-2, j-2) + fs(i-1, j-3))/4.0).also{dp[i][j]=it}
            }
        return fs((n+24)/25, (n+24)/25)
    }
}
