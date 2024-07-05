class Solution463 {
    fun islandPerimeter(grid: Array<IntArray>): Int =
        grid.foldIndexed(0) { i, r, row ->
            row.foldIndexed(r) { j, r, g ->
                r + if (g==1) 4 -(if (i!=0 && grid[i-1][j]==1) 2 else 0) - (if (j!=0 && grid[i][j-1]==1) 2 else 0) else 0 }
        }
}

