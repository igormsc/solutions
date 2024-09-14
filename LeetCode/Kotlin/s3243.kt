class Solution3243 {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val g = Array(n) { mutableListOf<Int>() }
        val dp = IntArray(n) {it}
        val res = mutableListOf<Int>()
        queries.forEach { q ->
            g[q[1]].add(q[0])
            (q[1]..<n).forEach { i ->
                dp[i] = minOf(dp[i], dp[i-1]+1)
                g[i].forEach { dp[i] = minOf(dp[i], dp[it]+1) }
            }
            res.add(dp[n-1])
        }
        return res.toIntArray()
    }
}