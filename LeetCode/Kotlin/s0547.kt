class Solution547 {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        if (isConnected.isEmpty()) return 0
        val n = isConnected.size
        val vis = BooleanArray(n)
        var res = 0

        fun dfs(u: Int) {
            vis[u] = true
            isConnected.indices.forEach { if (isConnected[u][it] == 1 && !vis[it]) dfs(it) }
        }

        isConnected.indices.forEach { u -> if (!vis[u]) res++.also{dfs(u)} }
        return res
    }
}
