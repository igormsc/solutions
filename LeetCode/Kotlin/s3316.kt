class Solution3316 {
    fun maxRemovals(source: String, pattern: String, targetIndices: IntArray): Int {
        val (n, m) = source.length to pattern.length
        val target = IntArray(n)
        val dp = IntArray(m + 1)
        for (i in targetIndices)
            target[i] += 1
        dp.fill(Int.MIN_VALUE)
        dp[m] = 0
        for (i in n - 1 downTo 0)
            (0..m).forEach { j ->
                dp[j] += target[i]
                if (j < m && source[i] == pattern[j])
                    dp[j] = maxOf(dp[j], dp[j + 1])
            }
        return dp[0]
    }

}
