class Solution3135 {
    fun minOperations(initial: String, target: String): Int {
        val (m, n) = initial.length to target.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        var mx = 0
        for (i in 1..m)
            for (j in 1..n) {
                if (initial[i - 1] == target[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                    mx = maxOf(mx, dp[i][j])
                }
            }
        return m + n - 2 * mx
    }

}