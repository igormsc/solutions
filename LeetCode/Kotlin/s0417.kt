class Solution417 {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        if (heights.isEmpty()) return res
        val (m, n) = heights.size to heights[0].size
        val vis = Array(m) { IntArray(n) }

        fun dfs(x: Int, y: Int, h: Int, p: Int) {
            if (x !in heights.indices || y !in heights[0].indices || heights[x][y] < h || vis[x][y].and(p) == p) return
            vis[x][y] = vis[x][y].or(p)
            if (vis[x][y] == 3) res.add(listOf(x,y))
            dfs(x+1, y, heights[x][y], vis[x][y])
            dfs(x-1, y, heights[x][y], vis[x][y])
            dfs(x, y+1, heights[x][y], vis[x][y])
            dfs(x, y-1, heights[x][y], vis[x][y])
        }

        heights.indices.forEach { i ->
            dfs(i, 0, Int.MIN_VALUE, 1)
            dfs(i, n-1, Int.MIN_VALUE, 2)
        }
        heights[0].indices.forEach { i ->
            dfs(0, i, Int.MIN_VALUE, 1)
            dfs(m-1, i, Int.MIN_VALUE, 2)
        }
        return res
    }
}
