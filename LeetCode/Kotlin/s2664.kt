class Solution2664 {
    fun tourOfKnight(m: Int, n: Int, r: Int, c: Int): Array<IntArray> {
        val g = Array(m) { IntArray(n) { -1 } }.also { it[r][c] = 0 }
        var flg = false

        fun dfs(i: Int, j: Int) {
            if (g[i][j] == m * n - 1) flg = true
            else {
                val dirs = intArrayOf(-2, -1, 2, 1, -2, 1, 2, -1, -2)
                for (k in 0..7) {
                    val (x, y) = i + dirs[k] to j + dirs[k + 1]
                    if (x in 0..<m && y in 0..<n && g[x][y] == -1) {
                        g[x][y] = g[i][j] + 1
                        dfs(x, y)
                        if (flg) return
                        g[x][y] = -1
                    }
                }
            }
        }

        dfs(r, c)
        return g
    }

}