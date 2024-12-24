class Solution847 {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val ds = Array(15) { IntArray(15) {255} }
        val n = graph.size
        for (u in graph.indices)
            for (v in graph[u]) ds[u][v] = 1

        for (k in graph.indices)
            for (i in graph.indices)
                for (j in graph.indices)
                    ds[i][j] = minOf(ds[i][k] + ds[k][j], ds[i][j])

        val dp = Array(1.shl(13)) { IntArray(13) {255} }
        graph.indices.forEach { dp[1.shl(it)][it] = 0 }
        for (grp in 1..<1.shl(n))
            for (u in graph.indices)
                for (v in graph.indices) {
                    val (src, dst) = 1.shl(u) to 1.shl(v)
                    if (grp.and(src) != 0 && grp.and(dst) == 0) dp[grp.or(dst)][v] = minOf(dp[grp][u]+ds[u][v], dp[grp.or(dst)][v])
                }

        return dp[1.shl(n)-1].min()
    }
}
