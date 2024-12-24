class Solution3142 {
    fun satisfiesConditions(grid: Array<IntArray>): Boolean =
        grid.withIndex().find { (i, row) ->
            row.withIndex().find {  (j, v) ->
                (j < row.lastIndex && v == grid[i][j+1]) || (i < grid.lastIndex && v != grid[i+1][j])
            } != null
        } != null
}