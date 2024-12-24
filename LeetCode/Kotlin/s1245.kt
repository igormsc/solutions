class Solution1245 {
    fun treeDiameter(edges: Array<IntArray>): Int {
        val n = edges.size + 1

        val g = Array(n){ mutableListOf<Int>() }
        var res = 0
        var x = 0

        edges.forEach { (u,v) ->
            g[u].add(v)
            g[v].add(u)
        }

        fun dfs(i: Int, fa: Int, t: Int) {
            for (j in g[i])
                if (j != fa)
                    dfs(j, i, t + 1)
            if (res < t) {
                res = t
                x = i
            }
        }

        dfs(0, -1, 0)
        dfs(x, -1, 0)
        return res
    }

}