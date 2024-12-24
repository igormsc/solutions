class Solution351 {
    fun numberOfPatterns(m: Int, n: Int): Int {
        val cross = Array(10) { IntArray(10) }.also {
            it[3][1] = 2; it[1][3] = 2
            it[7][1] = 4; it[1][7] = 4
            it[9][1] = 5; it[1][9] = 5; it[8][2] = 5; it[2][8] = 5; it[7][3] = 5; it[3][7] = 5; it[6][4] = 5; it[4][6] = 5
            it[9][3] = 6; it[3][9] = 6
            it[9][7] = 8; it[7][9] = 8 }

        val vis = BooleanArray(10)
        fun dfs(i: Int, cnt: Int): Int {
            if (cnt > n) return 0
            vis[i] = true
            var res = if (cnt >= m) 1 else 0
            for (j in 1..9) {
                val x = cross[i][j]
                if (!vis[j] && (x == 0 || vis[x])) res += dfs(j, cnt + 1)
            }
            vis[i] = false
            return res
        }

        return dfs(1, 1) * 4 + dfs(2, 1) * 4 + dfs(5, 1)
    }

}