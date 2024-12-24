class Solution3212 {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val (n, m) = grid.size to grid[0].size
        val dpX = Array(n + 1) { IntArray(m + 1) }
        val dpY = Array(n + 1) { IntArray(m + 1) }
        return (0..<n).sumOf { i ->
            (0..<m).count { j ->
                dpX[i+1][j+1] = dpX[i][j+1] + dpX[i+1][j] - dpX[i][j] + (if (grid[i][j] == 'X') 1 else 0)
                dpY[i+1][j+1] = dpY[i][j+1] + dpY[i+1][j] - dpY[i][j] + (if (grid[i][j] == 'Y') 1 else 0)
                dpX[i+1][j+1] == dpY[i+1][j+1] && dpX[i+1][j+1]>0
            }
        }
    }

}
