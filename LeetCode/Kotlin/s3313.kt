class Solution3313 {

    fun lastMarkedNodes(edges: Array<IntArray>): IntArray {
        val n = edges.size + 1
        val g = Array(n) { mutableListOf<Int>() }
        for ((u,v) in edges) {
            g[u].add(v)
            g[v].add(u)
        }

        fun dfs(i: Int, fa: Int, dist: IntArray) {
            for (j in g[i])
                if (j != fa) {
                    dist[j] = dist[i] + 1
                    dfs(j, i, dist)
                }

        }

        val dst1 = IntArray(n).also { it[0]=0 }
        dfs(0, -1, dst1)
        val a = maxNode(dst1)
        val dst2 = IntArray(n).also{ it[a]=0 }
        dfs(a, -1, dst2)
        val b = maxNode(dst2)
        val dst3 = IntArray(n).also{ it[b]=0 }
        dfs(b, -1, dst3)
        return (0..<n).fold(IntArray(n)) { r, i -> r[i] = if (dst2[i] > dst3[i]) a else b; r}
    }

    private fun maxNode(dist: IntArray): Int {
        var mx = 0
        for (i in dist.indices)
            if (dist[mx] < dist[i]) mx = i
        return mx
    }
}