class Solution797 {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val path = mutableListOf<Int>()
        val res = mutableListOf<List<Int>>()

        fun dfs(u: Int) {
            path.add(u)
            if (u == graph.lastIndex) res.add(path.toList())
            else graph[u].forEach { dfs(it) }
            path.removeLast()
        }

        dfs(0)
        return res
    }

}
