class Solution1857 {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val adj = Array(n) {mutableSetOf<Int>()}
        val idg = IntArray(n)
        edges.forEach { (u,v) ->
            adj[u].add(v)
            idg[v]++
        }
        val q = idg.indices.fold(mutableListOf<Int>()) { r, i -> if (idg[i]==0) r.add(i); r}
        val vis = IntArray(n)
        val dp = Array(n){IntArray(26)}
        var res = 0
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            dp[u][colors[u].code-'a'.code]++
            vis[u]++
            res = maxOf(res, dp[u].max())
            adj[u].forEach { v ->
                if (--idg[v] == 0) q.add(v) else if (idg[v] < 0) return -1
                dp[v].indices.forEach { j -> dp[v][j] = maxOf(dp[v][j], dp[u][j]) }
            }
        }
        return if (vis.any { it == 0}) -1 else res
    }
}

