class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val (m, n) = grid.size to grid[0].size
        grid.indices.forEach { i ->
            grid[i].indices.forEach { j ->
                if (i==0 && j != 0) grid[i][j] += grid[i][j-1]
                if (i!=0 && j ==0) grid[i][j] += grid[i-1][j]
                if (i!=0 && j!=0) grid[i][j] += minOf(grid[i-1][j],  grid[i][j-1])
            }
        }
        return grid.last().last()
    }
}
