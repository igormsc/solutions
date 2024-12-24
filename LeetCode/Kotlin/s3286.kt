class Solution3268 {
    fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val vis = Array(grid.size) { Array(grid[0].size) { BooleanArray(health + 1) }}

        fun dfs(health: Int, i: Int, j: Int): Boolean {
            var hl = health
            if (i !in 0..grid.lastIndex || j !in 0..grid[i].lastIndex || vis[i][j][hl]) return false
            vis[i][j][hl] = true
            if (grid[i][j] == 1) hl--
            if (hl < 1) return false
            if (i == grid.lastIndex && j == grid[i].lastIndex) return true
            return dfs(hl, i, j - 1) || dfs(hl, i, j + 1) || dfs(hl, i - 1, j) || dfs(hl, i + 1, j)
        }

        val res = dfs(health, 0, 0)
        return res
    }
}