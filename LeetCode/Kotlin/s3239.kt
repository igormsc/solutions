class Solution3239 {
    fun minFlips(grid: Array<IntArray>): Int =
        grid.indices.fold(0 to 0) { p, i ->
            grid[0].indices.fold(0 to 0) { (r, c), j ->
                (r + if (grid[i][j] != grid[i][grid[0].lastIndex - j]) 1 else 0) to (c + if (grid[i][j] != grid[grid.lastIndex - i][j]) 1 else 0)
            }.let { it.first + p.first to it.second + p.second}
        }.let { minOf(it.first / 2, it.second / 2)}
}