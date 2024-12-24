class Solution3249 {
    fun countGoodNodes(edges: Array<IntArray>): Int {
        var res = 0
        val adj = Array(100_005) { mutableListOf<Int>() }
        fun dfs(n: Int, p: Int): Int {
            var sz = 1
            val m = mutableMapOf<Int,Int>()
            adj[n].forEach { ch ->
                if (ch != p) {
                    val d = dfs(ch, n)
                    sz += d
                    m[d] = (m[d]?:0) + 1
                }
            }
            if (m.size<=1) res++
            return sz
        }

        edges.forEach { e ->
            val (u,v) = e
            adj[u].add(v)
            adj[v].add(u)
        }
        dfs(0,-1)
        return res
    }

}