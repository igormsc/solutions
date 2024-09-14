class Solution1905 {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        fun dfs(i: Int, j: Int): Int {
            if (!(i in grid2.indices && j in grid2[0].indices) || grid2[i][j] == 0) return 1
            grid2[i][j] = 0
            var res = 1.and(dfs(i - 1, j))
            res = res.and(dfs(i + 1, j))
            res = res.and(dfs(i, j - 1))
            res = res.and(dfs(i, j + 1))
            return res.and(grid1[i][j])
        }

        return grid1.indices.sumOf { i ->
                    grid1[0].indices.sumOf { j ->
                    if (grid2[i][j] == 1) dfs(i, j) else 0 } }
    }
}