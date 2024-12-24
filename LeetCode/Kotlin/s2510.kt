class Solution2510 {
    fun isThereAPath(grid: Array<IntArray>): Boolean {
        val (m, n) = grid.size to grid[0].size
        var s = m + n - 1
        if (s % 2 == 1) return false
        val arr = Array(m) { Array(n) {Array<Boolean?>(s) {null} }}

        fun dfs(i: Int, j: Int, k: Int): Boolean {
            if (i >= m || j >= n) return false
            val k = k + grid[i][j]
            if (arr[i][j][k] != null) return arr[i][j][k]!!
            if (k > s || i + j + 1 - k > s) return false
            if (i == m - 1 && j == n - 1) return k == s
            arr[i][j][k] = dfs(i + 1, j, k) || dfs(i, j + 1, k)
            return arr[i][j][k]!!
        }

        s = s shr 1
        return dfs(0, 0, 0)
    }

}
