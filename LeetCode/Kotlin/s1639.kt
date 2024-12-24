class Solution1639 {
    fun numWays(words: Array<String>, target: String): Int {
        val mod = 1_000_000_007L
        val dp = LongArray(target.length + 1).also{it[0]=1}
        words[0].indices.forEach { i ->
            val cnt = words.fold(LongArray(255)) { r, w -> r[w[i].code]++; r}
            (minOf(target.length, i+1) downTo 1).forEach { dp[it] = (cnt[target[it-1].code]*dp[it-1] + dp[it])%mod } }
        return dp[target.length].toInt()
    }
}
