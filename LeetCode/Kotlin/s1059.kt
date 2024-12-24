class Solution1059 {
    fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val g = Array(n) {mutableListOf<Int>()}
        val f = IntArray(n)
        val vis = BooleanArray(n)
        for (e in edges) g[e[0]].add(e[1])

        fun dfs(i: Int): Boolean {
            when {
                i == destination -> return g[i].isEmpty()
                f[i] != 0 -> return f[i] == 1
                vis[i] || g[i].isEmpty() -> return false
            }

            vis[i] = true
            for (j in g[i])
                if (!dfs(j)) { f[i] = -1; return false }
            f[i] = 1
            return true
        }

        return dfs(source)
    }

}