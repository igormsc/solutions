class Solution1192 {
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val g = Array(n) { mutableListOf<Int>() }
        val res = mutableListOf<List<Int>>()
        val dfn = IntArray(n)
        val low = IntArray(n)
        connections.forEach { (u,v) ->
            g[u].add(v)
            g[v].add(u)
        }

        var c = 0
        fun tarjan(u: Int, fa: Int) {
            low[u] = ++c
            dfn[u] = low[u]
            g[u].forEach { v ->
                if (v!=fa)
                    if (dfn[v] == 0) {
                        tarjan(v,u)
                        low[u] = minOf(low[u], low[v])
                        if (low[v] > dfn[u]) res.add(listOf(u,v))
                    } else low[u] = minOf(low[u], dfn[v])
                }
        }

        tarjan (0,-1)
        return res
    }
}
