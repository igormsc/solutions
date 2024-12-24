class Solution3195 {
    fun minimumArea(grid: Array<IntArray>): Int {
        var crd = intArrayOf(grid[0].lastIndex, grid.lastIndex, 0, 0)
        for (i in grid.indices)
            for (j in grid[i].indices)
                if (grid[i][j] == 1)
                    crd = intArrayOf(minOf(crd[0], j),minOf(crd[1], i),maxOf(crd[2], j),maxOf(crd[3], i))
        return (crd[2] - crd[0] + 1) * (crd[3] - crd[1] + 1)
    }
}
