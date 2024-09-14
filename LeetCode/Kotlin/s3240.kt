class Solution3240 {
    fun minFlips(grid: Array<IntArray>): Int {
        var (res, one, d) = intArrayOf(0,0,0)
        val (m,n) = grid.size to grid[0].size
        for (i in 0..<m / 2)
            for (j in 0..<n / 2) {
                val v = grid[i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][j] + grid[m - 1 - i][n - 1 - j]
                res += minOf(v, 4 - v)
            }
        if (n % 2 != 0)
            for (i in 0..<m / 2) {
                d += grid[i][n / 2] xor grid[m - 1 - i][n / 2]
                one += grid[i][n / 2] + grid[m - 1 - i][n / 2]
            }
        if (m % 2 != 0)
            for (j in 0..<n / 2) {
                d += grid[m / 2][j] xor grid[m / 2][n - 1 - j]
                one += grid[m / 2][j] + grid[m / 2][n - 1 - j]
            }
        if (n % 2 != 0 && m % 2 != 0) res += grid[m / 2][n / 2]
        if (d == 0 && one % 4 != 0) res += 2
        return res + d
    }
}