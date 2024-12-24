class Solution3004 {
    fun maximumSubtreeSize(edges: Array<IntArray>, colors: IntArray): Int {
        var res = 0
        val n = edges.size + 1
        val g = Array(n) { mutableListOf<Int>() }
        val d = IntArray(n) {1}
        for ((u,v) in edges) {
            g[u].add(v)
            g[v].add(u)
        }

        fun dfs(v: Int, fa: Int): Boolean {
            var f = true
            for (u in g[v])
                if (u != fa) {
                    val t = dfs(u, v)
                    f = f && colors[v] == colors[u] && t
                    d[v] += d[u]
                }
            if (f) res = maxOf(res, d[v])
            return f
        }

        dfs(0, -1)
        return res
    }

}