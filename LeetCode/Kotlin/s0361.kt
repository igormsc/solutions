class Solution361 {
    fun maxKilledEnemies(grid: Array<CharArray>): Int {
        val (m, n) = grid.size to grid[0].size
        val g = Array(m) { IntArray(n) }
        (0..<m).forEach { i ->
            var t = 0
            (0..<n).forEach { j ->
                if (grid[i][j] == 'W') t = 0
                else if (grid[i][j] == 'E') t++
                g[i][j] += t
            }
            t = 0
            (n - 1 downTo 0).forEach { j ->
                if (grid[i][j] == 'W') t = 0
                else if (grid[i][j] == 'E') t++
                g[i][j] += t
            }
        }
        (0..<n).forEach { j ->
            var t = 0
            (0..<m).forEach { i ->
                if (grid[i][j] == 'W') t = 0
                else if (grid[i][j] == 'E') t++
                g[i][j] += t
            }
            t = 0
            (m - 1 downTo 0).forEach { i ->
                if (grid[i][j] == 'W') t = 0
                else if (grid[i][j] == 'E') t++
                g[i][j] += t
            }
        }

        var res = 0
        for (i in 0..<m)
            for (j in 0..<n)
                if (grid[i][j] == '0') res = maxOf(res, g[i][j])
        return res
    }
}