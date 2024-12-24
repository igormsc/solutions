class Solution3203 {
    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {

        fun diam(edges: Array<IntArray>): Int {
            val m = edges.size + 1
            var res = 0
            val degree = IntArray(m)
            val depth = IntArray(m)
            val vis = BooleanArray(m)
            val q = mutableListOf<Int>()
            val g = edges.fold(Array(m) { mutableListOf<Int>() }) { r, (u,v) -> r[u].add(v); r[v].add(u); r}
            degree.indices.forEach { i ->
                val s = g[i].size
                degree[i] = s
                if (s == 1) q.add(i)
            }
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                vis[u] = true
                g[u].forEach { v ->
                    degree[v]--
                    if (degree[v] == 1) q.add(v)
                    if (!vis[v]) {
                        res = maxOf(res, depth[v] + depth[u] + 1)
                        depth[v] = maxOf(depth[v], depth[u] + 1)
                    }
                }
            }
            return res
        }

        val (d1, d2) = diam(edges1) to diam(edges2)
        return maxOf(d1, d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1)
    }

}
