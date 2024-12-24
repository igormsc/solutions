class Solution1406 {
    fun stoneGameIII(stoneValue: IntArray): String {
        val n = stoneValue.size
        val dp = IntArray(n+1)
        for (i in n-1 downTo 0) {
            var t = 0
            dp[i] = Int.MIN_VALUE
            for (j in i..<minOf(n, i+3)) {
                t += stoneValue[j]
                dp[i] = maxOf(t - dp[j+1], dp[i])
            }
        }
        return when {
            dp[0] > 0 -> "Alice"
            dp[0] < 0 -> "Bob"
            else -> "Tie"
        }
    }
}
