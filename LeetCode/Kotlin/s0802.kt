class Solution802 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val color = IntArray(n)

        fun dfs(u: Int): Boolean {
            if (color[u] > 0) return color[u] == 2
            color[u] = 1
            graph[u].forEach { if (color[u] != 2 && (color[it] == 1 || !dfs(it))) return false }
            color[u] = 2
            return true
        }

        return graph.indices.fold(mutableListOf<Int>()) { r, v -> if (dfs(v)) r.add(v); r}
    }
}
