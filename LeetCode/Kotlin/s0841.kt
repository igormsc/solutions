class Solution841 {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n =rooms.size
        val vis = BooleanArray(n)

        fun dfs(u: Int) {
            if (vis[u]) return
            else {
                vis[u] = true
                rooms[u].forEach { if (!vis[it]) dfs(it) }
            }
        }

        dfs(0)

        return vis.all {it}
    }
}