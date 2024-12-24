class Solution1259 {
    fun numberOfWays(numPeople: Int): Int {
        val dp = LongArray(numPeople + 1)
        val MOD = 1_000_000_007L

        fun dfs(i: Int): Long = when {
            i < 2 -> 1L
            dp[i] != 0L -> dp[i]
            else -> {
                    (0..<i step 2).forEach { j -> dp[i] = ((dp[i] + (dfs(j) * dfs(i - j - 2) % MOD)) % MOD) }
                    dp[i] } }

        return dfs(numPeople).toInt()
    }
}