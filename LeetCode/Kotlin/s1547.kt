class Solution1547 {
    fun minCost(n: Int, cuts: IntArray): Int {
        val cuts = cuts.toMutableList()
        cuts.addAll(listOf(0, n))
        cuts.sort()
        val m = cuts.size
        val dp = Array(m) { IntArray(m) {Int.MAX_VALUE} }
        (0..<m-1).forEach{ dp[it][it+1] = 0}
        (0..<m-2).forEach{ dp[it][it+2] = cuts[it+2] - cuts[it]}
        (m-4 downTo 0).forEach { i ->
            (i+3..<m).forEach { j ->
                dp[i][j] = (i+1..<j).minOf{ dp[i][it] + dp[it][j] } + cuts[j] - cuts[i]
            }
        }
        return dp.first().last()
    }
}
