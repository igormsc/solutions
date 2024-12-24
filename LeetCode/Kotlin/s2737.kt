class Solution2737 {
    fun minimumDistance(n: Int, edges: List<List<Int>>, s: Int, marked: IntArray): Int {
        val g = Array(n) { IntArray(n) { Int.MAX_VALUE/4} }
        for (e in edges) {
            val (u,v,w,) = e
            g[u][v] = minOf(g[u][v], w)
        }
        val dist = IntArray(n) { Int.MAX_VALUE/4}
        dist[s] = 0
        val vis = BooleanArray(n)
        for (i in 0..<n) {
            var t = -1
            for (j in 0..<n)
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) t = j
            vis[t] = true
            for (j in 0..<n)
                dist[j] = minOf(dist[j], dist[t] + g[t][j])

        }
        var res = Int.MAX_VALUE/4
        for (i in marked)
            res = minOf(res, dist[i])
        return if (res >= Int.MAX_VALUE/4) -1 else res
    }

}