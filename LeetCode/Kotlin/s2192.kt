class Solution2192 {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val adj = edges.fold(Array(n){ mutableListOf<Int>() }) { r, e -> r[e[1]].add(e[0]); r}

        fun dfs(node: Int, curr: MutableList<Int>, vis: BooleanArray) {
            vis[node] = true
            adj[node].forEach { n ->
                if (!vis[n]) {
                    curr.add(n)
                    dfs(n, curr, vis)
                }
            }
        }

        return (0..<n).fold(mutableListOf<MutableList<Int>>() ) { r, i ->
            val curr = mutableListOf<Int>()
            dfs(i, curr, BooleanArray(n))
            curr.sort()
            r.add(curr)
            r }.toList()
    }
}
