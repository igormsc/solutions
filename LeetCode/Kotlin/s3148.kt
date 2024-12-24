class Solution3148 {
    fun maxScore(grid: List<List<Int>>): Int {
        val grid = grid.map { it.toIntArray() }.toTypedArray()
        var res = -1_000_000
        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                val pre = minOf(if (i > 0) grid[i - 1][j] else 1_000_000, if (j > 0) grid[i][j - 1] else 1_000_000)
                res = maxOf(res, grid[i][j] - pre).also { grid[i][j] = minOf(grid[i][j], pre) }
            }
        }
        return res
    }
}
