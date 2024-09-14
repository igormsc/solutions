class Solution1140 {
    fun stoneGameII(piles: IntArray): Int {
        val pS = piles.clone()
        (pS.lastIndex - 1 downTo 0).forEach { pS[it] += pS[it + 1] }
        val dp = Array(piles.size) { IntArray(piles.size) }

        fun dfs(m: Int, p: Int): Int =
            when {
                p + 2 * m >= pS.size -> pS[p]
                dp[p][m] > 0 -> dp[p][m]
                else -> (1..2 * m)
                    .maxOf { pS[p] - dfs(maxOf(it, m), p + it) }
                    .also { dp[p][m] = it }
            }
        return dfs(1, 0)
    }

}
