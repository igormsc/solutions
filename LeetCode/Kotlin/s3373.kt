class Solution3373 {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
        val (m,n) = edges1.size + 1 to edges2.size + 1
        val par = BooleanArray(m)
        val skip = BooleanArray(n)

        fun dfs(i: Int, p: Int, g: Array<MutableList<Int>>, vis: BooleanArray, even: Boolean): Int {
            vis[i] = even
            return g[i].sumOf { if (it==p) 0 else dfs(it,i, g, vis, !even)  } + if (even) 1 else 0
        }

        val (e1, e2) = dfs(0,-1,adj(edges1), par, true) to dfs(0,-1,adj(edges2), skip, true)
        val (o1, o2) = m - e1 to n - e2
        return (0..<m).fold(IntArray(m)) { r, i -> r[i] = maxOf(e2,o2) + if (par[i]) e1 else o1  ;r}
    }

    private fun adj(edges: Array<IntArray>): Array<MutableList<Int>> = edges.fold(Array(edges.size+1){ mutableListOf() }) { r, (u,v) -> r[u].add(v); r[v].add(u); r }
}
