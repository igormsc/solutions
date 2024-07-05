class Solution861 {
    fun matrixScore(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        return (1..<n).fold(1.shl(n - 1) * m) { r, j ->
            r + (0..<m).count { grid[it][j] == grid[it][0] }.let { maxOf(it, m - it) * 1.shl(n - j - 1) }
        }
    }
}
