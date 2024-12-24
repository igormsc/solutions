class Solution785 {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val n = graph.size
        val colors = IntArray(n)

        fun dfs(u: Int, color: Int): Boolean {
            colors[u] = color
            graph[u].forEach {  if (colors[it] != -color && (colors[it] == color || !dfs(it, -color))) return false }
            return true
        }
        return !graph.indices.any { colors[it] == 0 && !dfs(it, 1) }
    }
}
