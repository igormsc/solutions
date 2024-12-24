class Solution3372 {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
        val (m,n) = edges1.size+1 to edges2.size+1
        val (g1,g2) = adj(edges1) to adj(edges2)

        val mx = (0..<n).maxOf{ dfs(it,-1,g2,k-1) }
        return (0..<m).fold(IntArray(m)) { r, i -> r[i] = mx + dfs(i,-1,g1,k); r}
    }

    private fun dfs(i: Int, j: Int, g: Array<MutableList<Int>>, k: Int): Int = when {
            k < 0 -> 0
            k == 0 -> 1
            else -> g[i].sumOf { if (it != j) dfs(it,i,g,k-1) else 0 } + 1 }

    private fun adj(edges: Array<IntArray>) =
        edges.fold(Array(edges.size+1){ mutableListOf<Int>() }) { r, (u,v) -> r[u].add(v); r[v].add(u); r }
}
